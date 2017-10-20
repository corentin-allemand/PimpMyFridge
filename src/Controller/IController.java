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
    double get_temperatureInterieur();
    double get_temperatureExterieur();
    double get_temperaturePeltier();

}
