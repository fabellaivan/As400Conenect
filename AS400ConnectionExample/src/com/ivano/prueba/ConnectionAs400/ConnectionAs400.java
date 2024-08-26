package com.ivano.prueba.ConnectionAs400;
import com.ibm.as400.access.*;

public class ConnectionAs400 {
    private AS400 as400;

    // Constructor
    public ConnectionAs400(String systemName, String userId, String password) {
        try {
            System.out.println("Conectando ");
            this.as400 = AS400Access.createAS400Connection(systemName, userId, password);
            this.as400.connectService(AS400.COMMAND);
            System.out.println("Conexión exitosa al sistema AS400.");
        } catch (AS400SecurityException e) {
            System.out.println("Error de seguridad: " + e.getMessage());
        } catch (ConnectionDroppedException e) {
            System.out.println("Conexión perdida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
    public AS400 getAS400() {
        return this.as400;
    }

    public boolean checkLibraryExists(String libraryName) {
        try {
            IFSFile library = new IFSFile(this.as400, "/QSYS.LIB/" + libraryName + ".LIB");
            return library.exists();
        } catch (Exception e) {
            System.out.println("Error al buscar la biblioteca: " + e.getMessage());
            return false;
        }
    }
}