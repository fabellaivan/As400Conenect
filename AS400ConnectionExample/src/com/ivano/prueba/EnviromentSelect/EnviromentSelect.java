package com.ivano.prueba.EnviromentSelect;
import java.util.Scanner;
import com.ivano.prueba.Login.Login;

public class EnviromentSelect {
    public static void showEnvironmentSelection() {
        Scanner scanner = new Scanner(System.in);
        boolean endpgm;
        // Mostrar las opciones al usuario
        System.out.println("Seleccione un entorno:\n" +
                              "1. Prod\n"+
                              "2. Desa\n"+
                              "3. Test\n");

        String selectedEnvironment = "";

        do{
            endpgm = true;
            switch (scanner.nextInt()) {
                case 1:
                    selectedEnvironment = "Prod";
                    break;
                case 2:
                    selectedEnvironment = "Desa";
                    break;
                case 3:
                    selectedEnvironment = "Test";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    endpgm = false;
                    break;
            }
        } while(!endpgm);


        // Mostrar la selección
        System.out.println("Seleccionado: " + selectedEnvironment);

        // Llamar al método de inicio de sesión con la selección
        Login.showLogin(selectedEnvironment);

        // Cerrar el scanner
        scanner.close();
    }

}
