import Device.ArduinoAdapter;
import Device.DeviceExecModelController;
import Device.DeviceListenerController;
import Device.IDeviceAdapter;

public class Main {

    public static void main(String[] args) {
        IDeviceAdapter arduino = new ArduinoAdapter();
        arduino.initializeDevice();
        DeviceListenerController DLC = new DeviceListenerController(arduino);
        DeviceExecModelController DEMC = new DeviceExecModelController();
        arduino.addObserver(DLC);

    }
}
