package Device;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import Model.IModel;

public class DeviceListenerController implements Observer{
    private IDeviceAdapter serialAdapter = null;
    private IModel M;
    public DeviceListenerController(IDeviceAdapter sA, IModel m) {
       serialAdapter = sA;
       M = m;
    }


    public void setListDevice(){
        M.set_listDevice(serialAdapter.getListDevice());
    }

    public void captureTrame(){
        String[] trame = serialAdapter.getBuffer().split("-");
        String[] buffTerm;

        for (String term : trame){
            buffTerm = term.split(":");
            sendDataToModel(buffTerm[0], Float.parseFloat(buffTerm[1]));
        }
        M.callObservers();
    }

    public void sendDataToModel(String ordre, float value){
        switch (ordre){
            case "EXT" :
                M.set_temperatureExterieur(value);
                break;
            case "INT" :
                M.set_temperatureInterieur(value);
                break;
            case "PLT" :
                M.set_temperaturePeltier(value);
                break;
            case "HMI" :

                break;
            case "ALT" :

                break;
            case "ANO" :

                break;
        }
    }

    @Override
    public void update(Observable obs, Object arg) {
        captureTrame();
    }

    public void selectDevice(String device) {
        serialAdapter.selectDevice(device);
    }

    public void sendTrame(){
        serialAdapter.sendData(Integer.toString(M.getInterfaceTemp()));
        System.out.println(Integer.toString(M.getInterfaceTemp()));
    }
}
