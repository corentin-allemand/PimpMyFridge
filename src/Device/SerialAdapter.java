package Device;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import javax.swing.filechooser.FileSystemView;
import java.util.Observable;

import java.util.Enumeration;
import java.util.Observer;

import java.io.*;



public class SerialAdapter extends Observable implements SerialPortEventListener{


    String[] portListPath = new String[1];
    CommPortIdentifier[] portList = new CommPortIdentifier[1];
    CommPortIdentifier selectedDevice = null;

    public SerialAdapter() {
        detectDevice();
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    private String buffer;
    SerialPort serialPort;
    /** Les ports utilisés */
    private static final String PORT_NAMES[] = {
            "/dev/tty.usbmodem1411",
            "/dev/tty.usbmodem1421",// Mac OS X
    };

    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;

    public void detectDevice(){
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        int i = 0;
        while (portEnum.hasMoreElements()) {

            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            if (currPortId.getPortType() == CommPortIdentifier.PORT_SERIAL){
                if (!currPortId.getName().equals("/dev/tty.Bluetooth-Incoming-Port") && !currPortId.getName().equals("/dev/cu.Bluetooth-Incoming-Port") && !currPortId.getName().equals("/dev/cu.usbmodem1411")  && !currPortId.getName().equals("/dev/cu.usbmodem1421")){
                    portList[i] = currPortId;
                    portListPath[i] = currPortId.getName();
                    i++;
                }
            }
        }
    }

    public void selectDevice(String devicePath){
        for (int i = 0 ; i < portList.length ; i++){
            if (portList[i].getName().equals(devicePath)){
                selectedDevice = portList[i];
                System.out.println("Device selected");
                break;
            }
        }
    }

    public void initialize() {

        if (selectedDevice == null) {
            System.out.println("Could not find Arduino port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) selectedDevice.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                buffer = input.readLine();
                setChanged();
                notifyObservers();

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public String getBuffer() {
        return this.buffer;
    }

    public void writeData(String trame)
    {
        byte dataTrame[];
        dataTrame = trame.getBytes();
        try
        {
            output.write(dataTrame);
            output.flush();
        }
        catch (Exception e)
        {
            System.out.println("Error writing");
        }
    }

    public String[] getPortListPath() {
        detectDevice();
        return portListPath;
    }
}