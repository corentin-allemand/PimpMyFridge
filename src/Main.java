import Device.ArduinoAdapter;
import Device.DeviceExecModelController;
import Device.DeviceListenerController;
import Device.IDeviceAdapter;
import Model.Model;
import Model.IModel;
import Controller.Controller;
import Controller.IController;
import View.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main extends Thread{

    public static void main(String[] args) throws IOException {
        IDeviceAdapter arduino = new ArduinoAdapter();
        IModel model = new Model();
        DeviceListenerController DLC = new DeviceListenerController(arduino, model);
        DeviceExecModelController DEMC = new DeviceExecModelController(arduino, model);
        IController controller = new Controller(model, DLC);
        View view = new View(controller);


        arduino.initializeDevice();


        arduino.addObserver(DLC);
        model.addObserver(DEMC);
        model.addObserver(view);

        controller.updateListDevice();
        controller.selectDevice("/dev/tty.usbmodem1411");





    }
}

