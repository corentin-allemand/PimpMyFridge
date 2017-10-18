package View;

import Controller.IController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;


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
        frame.setPreferredSize(new Dimension(1200,500));
        frame.setLocation(100,100);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        initFromModel();
        initGraphique();

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


    public View() {

    }

    public void initGraphique(){
        JFreeChart xylineChart = ChartFactory.createXYLineChart("Graphique des mesures de température", "Temps", "Température", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        final XYPlot plot =xylineChart.getXYPlot();
        plot.setRenderer( renderer );
        panelGraphique.setLayout(new BorderLayout());
        panelGraphique.add(chartPanel, BorderLayout.NORTH);
    }


    private XYDataset createDataset( ) {
        final XYSeries interieur = new XYSeries( "Température Intérieur" );
        interieur.add( 0.30 , 20.0 );
        interieur.add( 1.30 , 19.0 );
        interieur.add( 2.30, 18.0 );

        final XYSeries exterieur = new XYSeries( "Température Extérieur" );
        exterieur.add( 0.30 , 25.0 );
        exterieur.add( 1.30 , 25.0 );
        exterieur.add( 2.30 , 25.0 );

        final XYSeries peltier = new XYSeries( "Peltier" );
        peltier.add( 0.30 , 19.0 );
        peltier.add( 1.30 , 18.0 );
        peltier.add( 2.30 , 17.0 );

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( interieur );
        dataset.addSeries( exterieur );
        dataset.addSeries( peltier );
        return dataset;
    }



}
