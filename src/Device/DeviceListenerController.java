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
        System.out.println(serialAdapter.getBuffer());
        //String[] str_array = serialAdapter.getBuffer().split("$");
        /*
        String Text = str_array[0];
        String Tint = str_array[1];
        String Tplt = str_array[2];
        String Humi = str_array[3];
        */

        //System.out.println(Text + " - " + Tint + " - " + Tplt + " - " + Humi);

       //System.out.println(serialAdapter.getBuffer());
    }
}
