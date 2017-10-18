package View;

import Controller.IController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
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

    private XYSeries interieur;
    private XYSeries exterieur;
    private XYSeries peltier;
    private Millisecond now;
    Timestamp timestamp;
    Instant instant;
    Timestamp start_timestamp;
    Instant start_instant;



    private int InterfaceTemperature;

    public View(IController ic){
        IC = ic;
        now = new Millisecond();
        JFrame frame = new JFrame("Application Gestion du Frigo");
        frame.setPreferredSize(new Dimension(800,500));
        frame.setLocation(100,100);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        initFromModel();
        initGraphique();
        start_timestamp = new Timestamp(System.currentTimeMillis());
        start_instant = start_timestamp.toInstant();


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
        AddDataToDatasetInterieur();
        AddDataToDatasetExterieur();
        AddDataToDatasetPeltier();
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
        interieur = new XYSeries( "Température Intérieur" );
        exterieur = new XYSeries( "Température Extérieur" );
        peltier = new XYSeries( "Peltier" );

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( interieur );
        dataset.addSeries( exterieur );
        dataset.addSeries( peltier );
        return dataset;
    }

    public long getTime(){
        timestamp = new Timestamp(System.currentTimeMillis());
        instant = timestamp.toInstant();
        long sous = start_instant.toEpochMilli();
        long time = instant.toEpochMilli();
        long total = time - sous;
        return total/1000;
    }

    public void AddDataToDatasetInterieur(){
        interieur.add(getTime(),  IC.get_temperatureInterieur());
    }

    public void AddDataToDatasetExterieur(){

        exterieur.add(getTime(),  IC.get_temperatureExterieur());
    }
    public void AddDataToDatasetPeltier(){

        peltier.add(getTime(),  IC.get_temperaturePeltier());


    }


}
