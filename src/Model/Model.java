package Model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements IModel{

    private int _interfaceTemperature;
    private String _unite;
    private String _setHour;
    private String loadedParams[][];


    public Model() {

        initializeFromFile();
    }

    public void set_interfaceTemperature(int _interfaceTemperature) {
        this._interfaceTemperature = _interfaceTemperature;
        System.out.println("From Model");
        notifyObservers();
        setChanged();
    }

    public void initializeFromFile(){
        ParamsLoader P =new ParamsLoader();
        loadedParams = P.read();

        _interfaceTemperature = Integer.parseInt(loadedParams[0][1]);
        _unite = loadedParams[1][1];
        _setHour = loadedParams[2][1];
        System.out.println("Temp : " +_interfaceTemperature+ " unite : " + _unite + " Hour : " + _setHour);
        notifyObservers();
        setChanged();
    }

    public void saveInFile(){

    }

    public int getInterfaceTemp(){
        return _interfaceTemperature;
    }

    @Override
    public void addObserver(Object o) {
        this.addObserver((Observer) o);
    }
}
