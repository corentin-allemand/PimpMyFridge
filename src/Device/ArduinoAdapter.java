package Device;

import java.util.Observer;

import static Device.SerialAdapter.*;

public class ArduinoAdapter implements IDeviceAdapter{

    SerialAdapter serialAdapter;


    public ArduinoAdapter() {

    }

    @Override
    public void initializeDevice() {
        serialAdapter = new SerialAdapter();
    }

    @Override
    public String getSerialReadedValue() {
        return serialAdapter.getBuffer();
    }

    @Override
    public void addObserver(Object o) {
        serialAdapter.addObserver((Observer) o);
    }

    @Override
    public void sendData(String s) {
        serialAdapter.writeData(s);
    }

    @Override
    public String getBuffer() {
        return serialAdapter.getBuffer();
    }

    @Override
    public String[] getListDevice() {
        return serialAdapter.getPortListPath();
    }

    @Override
    public void selectDevice(String device) {
        serialAdapter.selectDevice(device);
        serialAdapter.initialize();
    }
}
