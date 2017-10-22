package Model;



public interface IModel {
    void addObserver(Object o);
    void set_interfaceTemperature(int _interfaceTemperature);
    void set_temperatureConfig(int _temperatureConfig);
    int get_temperatureConfig();
    int getInterfaceTemp();
    void set_interfaceUnit(String _unit);
    String getInterfaceUnit();
    void set_interfaceTimeZone(String _timeZone);
    String getInterfaceTimeZone();
    void initializeFromFile();
    void saveInFile();
    void set_temperatureInterieur(float _temperatureInterieur);
    void set_temperatureExterieur(float _temperatureExterieur);
    void set_temperaturePeltier(float _temperaturePeltier);
    float get_temperatureInterieur();
    float get_temperatureExterieur();
    float get_temperaturePeltier();
    void callObservers();
    void set_listDevice(String[] devices);
    public String[] get_listDevices();

}
