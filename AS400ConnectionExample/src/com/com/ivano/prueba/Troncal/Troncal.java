package com.ivano.prueba.Troncal;

import java.io.IOException;
import java.util.ArrayList;

import com.ivano.prueba.ConnectionAs400.AS400Util;
import com.ivano.prueba.ExcelSelect.ExcelSelect;
import com.ivano.prueba.Utils.Utils;

public class Troncal {
    private AS400Util cAs400;

    public Troncal(String sysIn, String user, String password){
        this.Connect(sysIn, user, password);
    }

    public void Init(){
        
        ExcelSelect excel = new ExcelSelect();

        try {
            ArrayList<ArrayList<String>> data = Utils.selectAndReadExcelFile();
            Utils.printData(data);
            System.out.println("Andoo11");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (excel.showExcelSelect()){
            System.out.println("Andoo");
        }

        this.Disconnect();


    }

    private void Connect(String sysIn, String user, String password){
        cAs400 = new AS400Util(sysIn,  
                               Utils.sanitizeInput(user),
                               Utils.sanitizeInput( password));

        if(cAs400.isConnected()){
            System.out.println("Todo mas que bien");
        } 
    }

    private void Disconnect(){
        this.cAs400.disconnect();
    }

    public boolean isConnected(){ return this.cAs400.isConnected();}

    public boolean checkLibT(String lib){ return this.cAs400.checkLib(lib);}
}
