package Device;

import java.util.Observable;
import java.util.Observer;

public class DeviceExecModelController implements Observer{
    private IDeviceAdapter serialAdapter = null;
    public DeviceExecModelController(IDeviceAdapter sA) {
        serialAdapter = sA;
    }

    public void sendTrame(String trame){
        serialAdapter.sendData(trame);
    }

    @Override
    public void update(Observable obs, Object arg) {

            //System.out.println(serialAdapter.getSerialReadedValue());
            // Update from model
    }
}
