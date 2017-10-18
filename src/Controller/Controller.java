package Controller;
import Model.IModel;

public class Controller implements IController{
    private IModel M;
    public Controller(IModel m) {
        this.M = m;
    }


    @Override
    public void setInterfaceTemperature(int temperature){
        M.set_interfaceTemperature(temperature);
        System.out.println("From Controller");
    }

    public int getInterfaceTemp(){
        return  M.getInterfaceTemp();
    }

}
