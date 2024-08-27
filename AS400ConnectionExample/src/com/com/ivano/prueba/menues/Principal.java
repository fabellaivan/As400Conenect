package com.ivano.prueba.menues;

import com.ivano.prueba.Troncal.Troncal;

import java.io.Console;

public class Principal {
    static Troncal troncal;
    static Console console = System.console();
    static String  lib;
    public static boolean Menu(String sysIn,String user, String pass){
        troncal =  new Troncal(sysIn,user, pass);
        boolean endpgm;
        int     pasoNro = 0;
        if (!troncal.isConnected()) return false;
        if (troncal.isConnected()) System.out.println("Llego");;
        do {
            endpgm = true;
            switch (pasoNro){
                case 1:
                if(checkLib()){
                    System.out.println();
                }
                case 0:
                    pasoNro++;
            }


        }while (!endpgm);

        return true;
    }

    private static boolean checkLib() {
        System.out.println("Ingrese biblioteca");
        lib = console.readLine();
        return troncal.checkLibT(lib);
    }
}
