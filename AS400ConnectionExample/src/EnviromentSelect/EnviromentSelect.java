package EnviromentSelect;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import Login.Login;
import Utils.Utils;
import Utils.Utils.WindowComponents;

public class EnviromentSelect {
    public static void showEnvironmentSelection() {
        WindowComponents components = Utils.createWindow("Miralo a Duraznito", 300, 200);
        placeComponents(components.getPanel(), components.getFrame());
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);
        // Crear los botones de opción

        String[] system = {"Prod", "Desa", "test"};
        JComboBox<String> comboBox2 = new JComboBox<>(system);
        comboBox2.setBounds(75, 40, 150, 25);
        panel.add(comboBox2);

        // Crear el botón de continuar
        JButton continueButton = new JButton("Continuar");
        continueButton.setBounds(95, 100, 100, 25);
        panel.add(continueButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // Agregar acción al botón de continuar
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login.showLogin(comboBox2.getSelectedItem().toString());
            }
        });

    }

}
