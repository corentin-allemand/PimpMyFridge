import Device.ArduinoAdapter;
import Device.DeviceExecModelController;
import Device.DeviceListenerController;
import Device.IDeviceAdapter;

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
        IDeviceAdapter arduino = new ArduinoAdapter();
        arduino.initializeDevice();
        DeviceListenerController DLC = new DeviceListenerController(arduino);
        DeviceExecModelController DEMC = new DeviceExecModelController(arduino);
        arduino.addObserver(DLC);
        new ReadInput(DEMC);

    }
}

/** Simulating view  **/
class ReadInput extends Thread{
    DeviceExecModelController demc;
    private String s;
    private BufferedReader br;
    private boolean close = false;
    public ReadInput(DeviceExecModelController O) throws IOException {
        demc = O;
        while (close == false){
            run();
        }
    }
    @Override
    public void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        demc.sendTrame(s);
    }
}
