package Device;

import java.util.Observable;
import java.util.Observer;

public class DeviceListenerController implements Observer{
    private IDeviceAdapter serialAdapter = null;
    public DeviceListenerController(IDeviceAdapter sA) {
       serialAdapter = sA;
    }

    @Override
    public void update(Observable obs, Object arg) {
       System.out.println("Je suis a jour sur la temperature");
       // Update from SerialAdapter
    }
}
