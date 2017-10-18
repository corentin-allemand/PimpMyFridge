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
        System.out.println(serialAdapter.getBuffer());
        Thread t = new Thread() {
            public void run() {

                M.set_temperatureExterieur(new Random().nextDouble());
                M.set_temperaturePeltier(new Random().nextDouble());
                M.set_temperatureInterieur(new Random().nextDouble());
                M.callObservers();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        t.start();
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
