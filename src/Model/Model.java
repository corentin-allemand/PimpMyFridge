package Model;
import Device.DeviceExecModelController;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Model extends Observable implements IModel{

    private int temp;

    public Model() {

    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        notifyObservers();
        setChanged();
    }

    @Override
    public void addObserver(Object o) {
        this.addObserver((Observer) o);
    }
}
