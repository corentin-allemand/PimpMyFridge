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

    @Override
    public void update(Observable obs, Object arg) {

        String[] str_array = ("EXT:12-INT:34-PLT:54-HMI:67-ALT:0-ANO:1").split("-");

        String Text = str_array[0];
        String Tint = str_array[1];
        String Tplt = str_array[2];
        String Humi = str_array[3];
        String AltConden = str_array[4];
        String AltAno = str_array[5];

       //System.out.println(serialAdapter.getBuffer());
    }
}
