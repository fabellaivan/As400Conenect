package com.ivano.prueba.ConnectionAs400;


public class AS400Util {
    private final ConnectionAs400 connection;

    public AS400Util(String systemName, String userId, String password) {
        this.connection = new ConnectionAs400(hostSystem(systemName), userId, password);
    }
    
    public boolean isConnected() {
        return this.stateConection();
    }

    public void disconnect() {
        this.disconnectAllServices();
        System.out.println("Desconectado!");
    }

    public boolean checkLib (String lib){
        return this.checkLibP(lib);
    }

    private String hostSystem(String sys){
        switch (sys) {
            case "Test":
                sys.replaceAll(sys, "172.18.3.16");
                break;
            case "Prod":
               // return sys.replaceAll(sys, "172.18.3.16");
            default :
                return sys.replaceAll(sys, "172.18.3.16");  
        }
        return sys;
    }
    private boolean stateConection(){
        try {
            return this.connection.getAS400().isConnected();
            
        } catch (Exception e) {
            System.out.println("La conexión al sistema AS400 no es válida: " + e.getMessage());
            return false;
        }
    }


    private void disconnectAllServices(){
        try {
            this.connection.getAS400().disconnectAllServices();
        } catch (Exception e) {
            System.out.println("La conexión al sistema AS400 no es válida: " + e.getMessage());
        }
    }


    private boolean checkLibP(String lib){
        try{
            return this.connection.checkLibraryExists(lib);
        }catch (Exception e) {
            System.out.println("Error al buscar la lib: " + e.getMessage());
        }
        return false;
    }

   /*  public boolean CommandCall(String command,String lib,String table){
        // Crear instancia de CommandCall
        try{
            CommandCall cmd = new CommandCall(this.connection.getAS400());
            switch (command) {
                case "1":
                        command = "DSPDBR FILE(" + lib + "/" + table + ")";
                    break;
            
                default:
                    break;
            }
            System.out.println(command);
            // Ejecutar el comando DSPDBR
            boolean success = cmd.run(command);

            if (!success)
                System.out.println("Error al ejecutar el comando: " + cmd.getMessageList());


        }catch (Exception e){

        }finally{
            
        }
       /* SpooledFileList splfList = new SpooledFileList(system);
        splfList.setUserFilter(user);
        splfList.setQueueFilter("/QSYS.LIB/QUSRSYS.LIB/" + user + ".OUTQ");
        splfList.openSynchronously();
        splfList.waitForListToComplete();

        long latestCreationTimestamp = 0;
        SpooledFile latestSpooledFile = null;
        Enumeration s = splfList.getObjects();
        return true;
    }*/
}