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

    public void set_temperatureConfig(int _temperatureConfig){
        M.set_temperatureConfig(_temperatureConfig);
    }

    public int get_temperatureConfig() {
       return M.get_temperatureConfig();
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

    public double get_temperatureInterieur() {
        return M.get_temperatureInterieur();
    }

    public double get_temperatureExterieur() {
        return M.get_temperatureExterieur();
    }

    public double get_temperaturePeltier() {
        return M.get_temperaturePeltier();
    }


}
