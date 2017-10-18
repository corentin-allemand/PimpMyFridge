package Controller;
import Model.IModel;

public class Controller implements IController{
    private IModel M;
    public Controller(IModel m) {
        this.M = m;
    }

    @Override
    public void setTemperature(int temperature) {
        M.setTemp(temperature);
    }

}
