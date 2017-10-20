package Model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements IModel{

    private int _interfaceTemperature; private String nameParam_interfaceTemperature = "initTemperature";
    private String _unit; private String nameParam_unit = "unitTemperature";
    private String _timeZone; private String nameParam_timeZone= "timeZone";
    private double _time;


    private double _temperatureInterieur;
    private double _temperatureExterieur;
    private double _temperaturePeltier;
    private String[][] loadedParams;


    public Model() {
        initializeFromFile();
        saveInFile();
    }

    public void initializeFromFile(){
        ParamsLoader P = new ParamsLoader();
        loadedParams = new String [3][2];
        loadedParams = P.read();
        _interfaceTemperature = Integer.parseInt(loadedParams[0][1]);
        _unit = loadedParams[1][1];
        _timeZone = loadedParams[2][1];
        notifyObservers();
        setChanged();
    }

    public void saveInFile(){
        ParamsSaver saver = new ParamsSaver();
        saver.deleteFile();
        saver.write(nameParam_interfaceTemperature, Integer.toString(_interfaceTemperature));
        saver.write(nameParam_unit, _unit);
        saver.write(nameParam_timeZone, _timeZone);
    }

    public int getInterfaceTemp(){
        return _interfaceTemperature;
    }

    public void set_interfaceTemperature(int _interfaceTemperature) {
        this._interfaceTemperature = _interfaceTemperature;
        System.out.println(_interfaceTemperature);
        notifyObservers();
        setChanged();
    }

    public String getInterfaceUnit(){
        return _unit;
    }

    public void set_interfaceUnit(String _unit) {
        this._unit = _unit;
        System.out.println(_unit);
        notifyObservers();
        setChanged();
    }

    public String getInterfaceTimeZone(){
        return _timeZone;
    }

    public void set_interfaceTimeZone(String _timeZone) {
        this._timeZone = _timeZone;
        notifyObservers();
        setChanged();
    }

    public void set_temperatureInterieur(double _temperatureInterieur) {
        this._temperatureInterieur = _temperatureInterieur;
    }

    public void set_temperatureExterieur(double _temperatureExterieur) {
        this._temperatureExterieur = _temperatureExterieur;
    }

    public void set_temperaturePeltier(double _temperaturePeltier) {
        this._temperaturePeltier = _temperaturePeltier;
    }

    public void callObservers(){
        notifyObservers();
        setChanged();
    }

    public double get_temperatureInterieur() {
        return _temperatureInterieur;
    }

    public double get_temperatureExterieur() {
        return _temperatureExterieur;
    }

    public double get_temperaturePeltier() {
        return _temperaturePeltier;
    }




    @Override
    public void addObserver(Object o) {
        this.addObserver((Observer) o);
    }
}
