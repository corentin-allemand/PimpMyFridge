package View;
import Controller.IController;

import java.util.Observable;
import java.util.Observer;

public class View implements IView, Observer{
    private IController IC;

    public View(IController  ic) {
        this.IC = ic;
    }

    public void pushButton(){
        IC.setTemperature(10);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("From View");
    }
}
