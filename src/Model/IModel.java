package Model;



public interface IModel {
    void addObserver(Object o);
    void set_interfaceTemperature(int _interfaceTemperature);
    int getInterfaceTemp();
    void set_interfaceUnit(String _unit);
    String getInterfaceUnit();
    void set_interfaceTimeZone(String _timeZone);
    String getInterfaceTimeZone();
    void initializeFromFile();
    void saveInFile();
}
