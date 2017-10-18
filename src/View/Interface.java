package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interface {
    private JButton BtnTemperatureDiminue;
    private JButton BtnTemperatureAugmente;
    private JLabel LabTemperatureVoulu;
    private JPanel panelMain;
    private JLabel LabTemperatureInterieur;
    private JLabel LabTemperatureExterieur;
    private JLabel LabTemperaturePeltier;
    private JLabel LabHumidite;

    private int temperature = 18;

    public Interface(){

        JFrame frame = new JFrame("Application Gestion du Frigo");
        frame.setPreferredSize(new Dimension(300,200));
        frame.setLocation(100,100);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        BtnTemperatureDiminue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temperature--;
                LabTemperatureVoulu.setText(""+temperature+" °C");

            }
        });
        BtnTemperatureAugmente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temperature++;
                LabTemperatureVoulu.setText(""+temperature+" °C");

            }
        });
    }



}
