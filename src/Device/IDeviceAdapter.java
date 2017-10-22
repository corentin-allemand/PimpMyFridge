package Device;

public interface IDeviceAdapter {
    void initializeDevice();
    String getSerialReadedValue();
    void addObserver(Object o);
    void sendData(String s);
    String getBuffer();
    String[] getListDevice();
    void selectDevice(String device);

}
