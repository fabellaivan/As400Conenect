public class ReadPfdta {
    
    
    public ReadPfdta() {
    }


    public static void read(String table, String lib, String user, AS400 system) throws AS400SecurityException, IOException {

        try {

            // Crear instancia de CommandCall
            CommandCall cmd = new CommandCall(system);
            String command = "DSPDBR FILE(" + lib + "/" + table + ")";
            System.out.println(command);
            // Ejecutar el comando DSPDBR
            boolean success = cmd.run(command);

            if (!success)
                System.out.println("Error al ejecutar el comando: " + cmd.getMessageList());

            SpooledFileList splfList = new SpooledFileList(system);
            splfList.setUserFilter(user);
            splfList.setQueueFilter("/QSYS.LIB/QUSRSYS.LIB/" + user + ".OUTQ");
            splfList.openSynchronously();
            splfList.waitForListToComplete();

            long latestCreationTimestamp = 0;
            SpooledFile latestSpooledFile = null;
            Enumeration s = splfList.getObjects();

            while (s.hasMoreElements()) {
                SpooledFile splf = (SpooledFile) s.nextElement();                
                String creationDate = splf.getCreateDate();
                String creationTime = splf.getCreateTime();
                long creationTimestamp = Long.parseLong(creationDate + creationTime);
                if (creationTimestamp > latestCreationTimestamp) {
                    latestCreationTimestamp = creationTimestamp;
                    latestSpooledFile = splf;
                }

            } // Leer y procesar el contenido del archivo en spool más reciente
    
            if (latestSpooledFile != null) {
                String spooledFileName = latestSpooledFile.getStringAttribute(SpooledFile.ATTR_SPOOLFILE);
                System.out.println("Archivo en spool más reciente: " + spooledFileName);
                String charset = "Cp500";         
                System.out.println("Probando con codificación: " + charset);
                BufferedReader reader = new BufferedReader(new InputStreamReader(latestSpooledFile.getPageInputStream(null), charset));
                String line;
                Integer num = 0;
                boolean bandera = false;
                // prueba(latestSpooledFile);
                while ((line = reader.readLine()) != null) {
                
                    // Procesar cada línea del contenido del archivo en spool
                    if(line.contains("Número de archivos dependientes")){
                        List<Integer> todosLosNumeros = new ArrayList<Integer>();
                        Matcher encuentrador = Pattern.compile("\\d+").matcher(line);
                        while (encuentrador.find()) { 
                            todosLosNumeros.add(Integer.parseInt(encuentrador.group()));//cantidad de logicos
                        } 
                        num = todosLosNumeros.getLast();
                    }
                    if (bandera){
                        System.out.println(line);
                        // Separar la cadena en partes usando el delimitador "?{?"
                        reemplazaCaracter(line);
                      
                        
                    }
                    if(line.contains("Restricción") && num > 0 ){
                        bandera = true;                    
                    }
                }
                reader.close();
                
            } else {
                System.out.println("No se encontraron archivos en spool para " + user);
            }
            splfList.close();
        } catch (Exception e) {
            // Maneje las excepciones...
            System.out.println("Error: " + e.getMessage());
        } finally {

        }

    }
    
    public static String reemplazaCaracter(String str ) {
        String output = " ";
        for (char ch : str.toCharArray()) {
           // System.out.println("Caracter: " + ch + " Codigo: " + (int) ch);
            int code = (int) ch;
            if ((code >= 65 && code <= 90) || (code>47 && code<58)) {
                output += ch; 
            }
            if(code>123 && code < 255)output += " ";
        }
        return output;
    }
}
