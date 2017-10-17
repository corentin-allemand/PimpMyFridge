package Device;

public interface IDeviceAdapter {
    void initializeDevice();
    String getSerialReadedValue();
    void addObserver(Object o);
    void sendData(String s);
}
