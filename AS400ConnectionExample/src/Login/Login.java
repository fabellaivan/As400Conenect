package Login;

import javax.swing.*;

import Troncal.Troncal;
import Utils.Utils;
import Utils.Utils.WindowComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login {
    static String sysIn;
    public static void showLogin(String system) {
        sysIn = system;
        WindowComponents components = Utils.createWindow("Miralo a Duraznito", 300, 200);   
        placeComponents(components.getPanel(),components.getFrame()); 
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        // Crear la etiqueta de usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Crear el campo de texto para el usuario
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Crear la etiqueta de contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Crear el campo de texto para la contraseña
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Crear el botón de login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Agregar acción al botón de login
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Troncal newTroncal = new Troncal(sysIn, userText.getText(), new String( passwordText.getPassword()));
                newTroncal.Init(); 
                frame.dispose();    
            }
        });
    }

}
