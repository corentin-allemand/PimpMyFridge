package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private JButton temperatureDiminue;
    private JButton temperatureAugmente;
    private JLabel temperatureVoulu;
    private JPanel panelMain;

    public Interface(){

        JFrame frame = new JFrame("Application Gestion du Frigo");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        temperatureDiminue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Yo");
                System.out.println("Coucou");
            }
        });
    }
}
