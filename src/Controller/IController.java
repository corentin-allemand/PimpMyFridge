package Controller;

public interface IController {
    void setInterfaceTemperature(int temperature);
    void set_temperatureConfig(int _temperatureConfig);
    int get_temperatureConfig();
    int getInterfaceTemp();
    void set_interfaceUnit(String _unit);
    String getInterfaceUnit();
    void set_interfaceTimeZone(String _timeZone);
    String getInterfaceTimeZone();
    void initializeFromFile();
    void saveInFile();
    float get_temperatureInterieur();
    float get_temperatureExterieur();
    float get_temperaturePeltier();
    float get_humidity();
    int get_alertRosee();
    int get_alertTemp();
    void updateListDevice();
    void selectDevice(String device);
    void sendData();
    public String[] getDevices();
}
