package Model;
import Device.DeviceExecModelController;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Model extends Observable implements IModel{

    private int _interfaceTemperature;

    public Model() {


    }

    public void set_interfaceTemperature(int _interfaceTemperature) {
        this._interfaceTemperature = _interfaceTemperature;
        System.out.println("From Model");
        notifyObservers();
        setChanged();
    }

    @Override
    public void addObserver(Object o) {
        this.addObserver((Observer) o);
    }
}
