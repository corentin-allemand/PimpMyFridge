package Device;

public class DeviceExecModelController {
    private IDeviceAdapter serialAdapter = null;
    public DeviceExecModelController(IDeviceAdapter sA) {
        serialAdapter = sA;
    }

    public void sendTrame(String trame){
        serialAdapter.sendData(trame);
    }
}
