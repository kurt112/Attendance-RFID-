package ATTENDANCE_LOGIN.GSM_MODEM;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import gnu.io.*;

/**
 *Created by Kurt Lupin C. Orioque
 *Email Address: kurtorioque112@gmail.com
 *ContactNumber: 09953045981
 *Linkedin: https://github.com/kurt112
 *Github: https://www.linkedin.com/in/kurt-lupin-orioque-2946a6157/
 *Bitbucket: https://bitbucket.org/%7B49153846-f85c-4553-9ecb-714516a680b7%7D/
 *Date: ${MONTH} ${DAY}, ${YEAR}
 *Time: ${TIME}
 *User: ${USER}
 **/

public class GSMConnect implements SerialPortEventListener,
        CommPortOwnershipListener {

    private static String comPort; // This C   OM Port must be connect with GSM Modem or your mobile phone
    private static CommPortIdentifier portId = null;
    private static InputStream inputStream = null;
    private static OutputStream outputStream = null;
    private static SerialPort serialPort;

    /**
     * Creates a new instance of GSMConnect
     */

    public GSMConnect(String comm) {
        comPort = comm;

    }


    /**
     *
     * @return true if the porn has a GSM modem and false if not found
     */
    public static synchronized boolean init() {
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(comPort)) {
//                    System.out.println("Got PortName");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is what your modem capable of
     */

    public static synchronized void checkStatus() {
        Runnable runnable = () -> send("AT+CREG?\r\n");
        System.out.println("check stats");
        new Thread(runnable).start();
    }


    /**
     *
     * @param cmd This code is for sending value to the modem
     *
     */

    private static synchronized void send(String cmd) {

        Runnable runnable = () -> {

            try {
                outputStream.write(cmd.getBytes());
            } catch (IOException e) {
                System.out.println("Something went wrong");

            }

        };

        new Thread(runnable).start();
    }

    /**
     *
     * @param phoneNumber Number of the Recipient
     * @param message The message you are sending
     *
     *       This code is for Sending Data to the modem
     *  See the sms command for more info
     */

    public static synchronized void sendMessage(String phoneNumber, String message) {
        char quotes = '"';

        send("AT+CMGS=" + quotes + phoneNumber + quotes + "\r\n");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
        send(message + '\032');
        System.out.println("Message Sent");
    }


    /*
        This method is for connecting to the modem This method is the important one
     */

    public synchronized boolean connect() throws NullPointerException {

        if (portId != null) {

            try {
                portId.addPortOwnershipListener(this);

                serialPort = (SerialPort) portId.open("MobileGateWay", 2000);
                serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                System.out.println("1");
                try {
                    inputStream = serialPort.getInputStream();
                    outputStream = serialPort.getOutputStream();
                    System.out.println("2");
                    try {
                        /** These are the events we want to know about*/
                        serialPort.addEventListener(this);
                        serialPort.notifyOnDataAvailable(true);
                        serialPort.notifyOnRingIndicator(true);
                        System.out.println("3");
                    } catch (TooManyListenersException e) {

                        e.printStackTrace();

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                }

            } catch (PortInUseException | UnsupportedCommOperationException e) {
                e.printStackTrace();
            }

//            send("ATZ\r\n");
            System.out.println("5");
            return true;
        }

        return false;

    }


    /**
     *
     * @param serialPortEvent The event of Serial port
     */
    public synchronized void serialEvent(SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            case SerialPortEvent.DATA_AVAILABLE:

                byte[] readBuffer = new byte[2048];
                try {
                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);

                        System.out.print(numBytes);
                    }

                    System.out.print(new String(readBuffer));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * @param type Getting the status of Port
     */

    public synchronized void ownershipChange(int type) {
        switch (type) {
            case CommPortOwnershipListener.PORT_UNOWNED:
//                System.out.println(portId.getName() + ": PORT_UNOWNED");
                break;
            case CommPortOwnershipListener.PORT_OWNED:
//                System.out.println(portId.getName() + ": PORT_OWNED");
                break;
            case CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED:
                break;
        }

    }

    //Just Closing the port

    public synchronized void closePort() {
        serialPort.close();
//        System.exit(0);
    }

//    /**
//     * @param number  number of the Recepient
//     * @param message Your message when texting
//     * @return true if The text message is succesful
//     */

//    public static void sendSMS(String number, String message) {
//        GSMConnect gsm = new GSMConnect("COM1");
//        if (gsm.init()) {
//            gsm.connect();
////            gsm.checkStatus();
//            gsm.sendMessage("09476663925","Test from Server");
////            gsm.closePort();
////            return true;
//        }

    //        else System.out.println("Can't init this card"); //return false;
//    }

    public static void main(String[] args) {

//        System.out.println("im in main");
//                GSMConnect gsm = new GSMConnect("COM1");
//        if (gsm.init()) {
//            if(gsm.connect()){
//                gsm.sendMessage("09217765961","Test from Server");
//                gsm.closePort();
//            }else{
//                System.out.println("Can't Connect");
//            }
//
//        }else{
//            System.out.println("Wrong port number set the gsm modem port to 1");
//        }

    }
}