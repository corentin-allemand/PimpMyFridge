import Device.ArduinoAdapter;
import Device.DeviceExecModelController;
import Device.DeviceListenerController;
import Device.IDeviceAdapter;
import Model.Model;
import Model.IModel;
import Controller.Controller;
import Controller.IController;
import View.View;
import View.IView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main extends Thread{

    /** DATA FOR ReadInput  **/
    private String s;
    private BufferedReader br;
    private boolean close = false;


    public static void main(String[] args) throws IOException {
        IModel model = new Model();
        IController controller = new Controller(model);
        IView view = new View(controller);
        IDeviceAdapter arduino = new ArduinoAdapter();

        arduino.initializeDevice();
        DeviceListenerController DLC = new DeviceListenerController(arduino);
        DeviceExecModelController DEMC = new DeviceExecModelController(arduino);
        arduino.addObserver(DLC);
        model.addObserver(DEMC);
        model.addObserver(view);
    }
}

