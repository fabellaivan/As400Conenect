package com.ivano.prueba.Login;

import com.ivano.prueba.menues.Principal;
import java.io.Console;
import java.util.Arrays;



public class Login {
    static String  sysIn;
    static Console console = System.console();
    static String  user;
    static String  pass;
    static boolean endpgm;
    static int     pasoNro = 0;

    public static void showLogin(String system) {

        sysIn = system;

        do{
            endpgm = true;
            switch (pasoNro){
                case 1:
                    pasoNro = sigOn() ? pasoNro + 1 : 0;
                case 2:
                    pasoNro = Principal.Menu(sysIn,user, pass)
                                            ? pasoNro + 1 : 0;
                case 0:
                    pasoNro++;
                    endpgm = false;
                break;
            }
        }while(!endpgm);
    }

    private static boolean sigOn(){
        System.out.println("Ingrese Usuario");
        user = console.readLine();
        System.out.println("Ingrese password");
        pass = Arrays.toString(console.readPassword());
        return true;
    }
}
