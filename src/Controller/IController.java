package Controller;

public interface IController {
    void setInterfaceTemperature(int temperature);
    int getInterfaceTemp();
    void set_interfaceUnit(String _unit);
    String getInterfaceUnit();
    void set_interfaceTimeZone(String _timeZone);
    String getInterfaceTimeZone();
    void initializeFromFile();
    void saveInFile();
}
