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

    @Override
    public void set_interfaceUnit(String _unit) {
        M.set_interfaceUnit(_unit);
    }

    @Override
    public String getInterfaceUnit() {
        return M.getInterfaceUnit();
    }

    @Override
    public void set_interfaceTimeZone(String _timeZone) {
        M.set_interfaceTimeZone(_timeZone);
    }

    @Override
    public String getInterfaceTimeZone() {
        return M.getInterfaceTimeZone();
    }

    @Override
    public void initializeFromFile() {
        M.initializeFromFile();
    }

    @Override
    public void saveInFile() {
        M.saveInFile();
    }

}
