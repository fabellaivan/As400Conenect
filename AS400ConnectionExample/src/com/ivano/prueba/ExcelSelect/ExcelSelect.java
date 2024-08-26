package com.ivano.prueba.ExcelSelect;

import java.io.File;
import java.awt.event.*;
import javax.swing.*;

import com.ivano.prueba.Utils.Utils;
import com.ivano.prueba.Utils.Utils.WindowComponents;

public class ExcelSelect {

    public boolean showExcelSelect(){

        WindowComponents components = Utils.createWindow("Miralo a Duraznito", 300, 200);   
        placeComponents(components.getPanel(),components.getFrame());
        

        return true;
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        JButton selectXlsx = new JButton("Seleccionar xlsx");
        selectXlsx.setBounds(10, 80, 80, 25);
        panel.add(selectXlsx);
        frame.setVisible(true);
        selectXlsx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    // Mostrar diálogo para seleccionar archivo
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // Aquí puedes manejar el archivo seleccionado
                        JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());
                        System.out.println(selectedFile.toString());
                     
                    }
                // Proceder al login
                frame.dispose();
            }
        });
    }

}
