package com.ivano.prueba.Utils;

import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
//import org.apache.poi.ss.usermodel.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Utils {

    public static String sanitizeInput(String input) {
        // Remover cualquier carácter no alfanumérico (excepto algunos caracteres permitidos)
        return input.replaceAll("[^a-zA-Z0-9_@.-]$", "");
    }

    public static WindowComponents createWindow(String title, int width, int height) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        frame.add(panel);
        
        // Retornar un objeto contenedor con el frame y el panel
        return new WindowComponents(frame, panel);
    }

    public static class WindowComponents {
        private final JFrame frame;
        private final JPanel panel;

        public WindowComponents(JFrame frame, JPanel panel) {
            this.frame = frame;
            this.panel = panel;
        }

        public JFrame getFrame() {
            return frame;
        }

        public JPanel getPanel() {
            return panel;
        }
    }

    public static ArrayList<ArrayList<String>> selectAndReadExcelFile() throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo XLSX");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //return 0;//readExcelFile(selectedFile);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
        return new ArrayList<>();
    }

//   private static ArrayList<ArrayList<String>> readExcelFile(File file) throws IOException {
//        ArrayList<ArrayList<String>> data = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(file);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheetAt(0);
//            System.out.println("Andoo1212");
//            // for (Row row : sheet) {
//            //     ArrayList<String> rowData = new ArrayList<>();
//            //     for (Cell cell : row) {
//            //         rowData.add(cell.toString());
//            //     }
//            //     data.add(rowData);
//            // }
//        }
//
//        return data;
//    }

    public static void printData(ArrayList<ArrayList<String>> data) {
        for (ArrayList<String> row : data) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
    
}
