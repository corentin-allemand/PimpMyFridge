package Device;

import Model.IModel;

import java.util.Observable;
import java.util.Observer;

public class DeviceExecModelController implements Observer{
    private IDeviceAdapter serialAdapter = null;
    private IModel M;
    public DeviceExecModelController(IDeviceAdapter sA, IModel m) {
        serialAdapter = sA;
        M = m;
    }



    @Override
    public void update(Observable obs, Object arg) {

        //serialAdapter.sendData(Integer.toString(M.getInterfaceTemp()));
        //System.out.println("Send consigne");
    }
}
