import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.ConnectionDroppedException;

public class AS400ConnectionExample {
    public static void main(String[] args) {
        // IP del AS400
        String systemName = "172.18.3.16";
        // Usuario del AS400
        String userId = "inf1ivan";
        // Contraseña del AS400
        String password = "suenios$2";
        
        // Crear una instancia de AS400
        AS400 as400 = new AS400(systemName, userId, password);
        
        try {
            // Intentar conectarse al sistema AS400
            as400.connectService(AS400.COMMAND);

            // Imprimir mensaje de éxito
            System.out.println("Conexión exitosa al sistema AS400.");

        } catch (AS400SecurityException e) {
            System.out.println("Error de seguridad: " + e.getMessage());
        } catch (ConnectionDroppedException e) {
            System.out.println("Conexión perdida: " + e.getMessage());
        }  catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            as400.disconnectAllServices();
        }
    }
}
