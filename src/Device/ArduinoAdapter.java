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
        serialAdapter.initialize();
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
            }
        };
        t.start();
        System.out.println("Initialized...");
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
}
