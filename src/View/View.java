package View;

import Controller.IController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


public class View implements Observer{
    private IController IC;

    private JButton BtnTemperatureDiminue;
    private JButton BtnTemperatureAugmente;
    private JLabel LabTemperatureVoulu;
    private JPanel panelMain;
    private JLabel LabTemperatureInterieur;
    private JLabel LabTemperatureExterieur;
    private JLabel LabTemperaturePeltier;
    private JLabel LabHumidite;
    private JButton BtnValider;
    private JTabbedPane tabbedPane1;
    private JPanel paneltemperature;
    private JPanel panelConfiguration;
    private JPanel panelGraphique;

    private int InterfaceTemperature;

    public View(IController ic){
        IC = ic;

        JFrame frame = new JFrame("Application Gestion du Frigo");
        /*frame.setPreferredSize(new Dimension(1200,700));
        frame.setLocation(100,100);*/
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        initFromModel();



        BtnTemperatureDiminue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceTemperature--;
                LabTemperatureVoulu.setText(""+InterfaceTemperature+" °C");

            }
        });
        BtnTemperatureAugmente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceTemperature++;
                LabTemperatureVoulu.setText(""+InterfaceTemperature+" °C");

            }
        });
        BtnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IC.setInterfaceTemperature(InterfaceTemperature);
            }
        });
    }



    @Override
    public void update(Observable o, Object arg) {

    }

    public void initFromModel(){
        InterfaceTemperature = IC.getInterfaceTemp();
        LabTemperatureVoulu.setText(""+InterfaceTemperature+" °C");
    }


}
