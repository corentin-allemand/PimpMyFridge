package Model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements IModel{

    private int _interfaceTemperature = 18;

    public Model() {


    }

    public void set_interfaceTemperature(int _interfaceTemperature) {
        this._interfaceTemperature = _interfaceTemperature;
        System.out.println("From Model");
        notifyObservers();
        setChanged();
    }

    public int getInterfaceTemp(){
        return _interfaceTemperature;
    }

    @Override
    public void addObserver(Object o) {
        this.addObserver((Observer) o);
    }
}
