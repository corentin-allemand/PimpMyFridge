package Model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements IModel{

    private int _interfaceTemperature;
    private int _temperatureConfig; private String nameParam_temperatureConfig = "initTemperature";
    private String _unit; private String nameParam_unit = "unitTemperature";
    private String _timeZone; private String nameParam_timeZone= "timeZone";
    private double _time;


    private float _temperatureInterieur;
    private float _temperatureExterieur;
    private float _temperaturePeltier;
    private float _humidity;
    private int _alertRosee;

    private int _alertTemp;

    private String[][] loadedParams;

    private String[] _listDevices;

    public String[] get_listDevices() {
        return _listDevices;
    }

    public Model() {
        initializeFromFile();
        saveInFile();
    }

    public void initializeFromFile(){
        ParamsLoader P = new ParamsLoader();
        loadedParams = new String [3][2];
        loadedParams = P.read();
        _temperatureConfig = Integer.parseInt(loadedParams[0][1]);
        _unit = loadedParams[1][1];
        _timeZone = loadedParams[2][1];
        callObservers();
    }

    public void saveInFile(){
        ParamsSaver saver = new ParamsSaver();
        saver.deleteFile();
        saver.write(nameParam_temperatureConfig, Integer.toString(_temperatureConfig));
        saver.write(nameParam_unit, _unit);
        saver.write(nameParam_timeZone, _timeZone);
    }

    public int getInterfaceTemp(){
        return _interfaceTemperature;
    }

    public void set_interfaceTemperature(int _interfaceTemperature) {
        this._interfaceTemperature = _interfaceTemperature;
        callObservers();
    }

    public void set_temperatureConfig(int _temperatureConfig){
        this._temperatureConfig = _temperatureConfig;
        callObservers();
    }
    public int get_temperatureConfig(){
        return  _temperatureConfig;
    }

    public String getInterfaceUnit(){
        return _unit;
    }

    public void set_interfaceUnit(String _unit) {
        this._unit = _unit;
        callObservers();
    }

    public String getInterfaceTimeZone(){
        return _timeZone;
    }

    public void set_interfaceTimeZone(String _timeZone) {
        this._timeZone = _timeZone;
        callObservers();
    }

    public void set_temperatureInterieur(float _temperatureInterieur) {
        this._temperatureInterieur = _temperatureInterieur;
    }

    public void set_temperatureExterieur(float _temperatureExterieur) {
        this._temperatureExterieur = _temperatureExterieur;
    }

    public void set_temperaturePeltier(float _temperaturePeltier) {
        this._temperaturePeltier = _temperaturePeltier;
    }

    public void callObservers(){
        notifyObservers();
        setChanged();
    }

    public float get_temperatureInterieur() {
        return _temperatureInterieur;
    }

    public float get_temperatureExterieur() {
        return _temperatureExterieur;
    }

    public float get_temperaturePeltier() {
        return _temperaturePeltier;
    }

    @Override
    public void addObserver(Object o) {
        this.addObserver((Observer) o);
    }

    @Override
    public void set_listDevice(String[] devices) {
        _listDevices = devices;
        for (String device : devices) {
            System.out.println(device);
        }
        callObservers();
    }

    @Override
    public void set_humidity(float _humidity) {
        this._humidity = _humidity;
    }

    @Override
    public void set_alertRosee(int _alertRosee) {
        this._alertRosee = _alertRosee;
    }

    @Override
    public void set_alertTemp(int _alertTemp) {
        this._alertTemp = _alertTemp;
    }

    public float get_humidity() {
        return _humidity;
    }

    public int get_alertRosee() {
        return _alertRosee;
    }

    public int get_alertTemp() {
        return _alertTemp;
    }
}
