/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.io.BufferedReader;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

/**
 *
 * @author Team 2035
 */
public class ArduinoConnection extends Subsystem {

    private SocketConnection server;
    private InputStream inputStream;
    private InputStreamReader reader;
    private BufferedReader buffRead;
    private OutputStream outputStream;

    private Thread connect;

    private String arduinoIP = "10.20.35.12";
    private String arduinoPort = "1140";

    private boolean updaterunning = false;
    private Timer periodicTimer;
    private static String pattern;
    private boolean shouldRunUpdate = true;
    public static boolean resetNeeded = false;

    public ArduinoConnection() {
        pattern = null;
        resetNeeded = false;
        periodicTimer = new Timer();
        connect = new Thread() {
            public void run() {
                //while (true) {
                    arduinoConnection();
                //}
            }
        };
        connect.start();
    }
    

    private synchronized void arduinoConnection() {
        System.out.println("acceptConnections");
        // Open the server
        while (true) {
            try {
                server = (SocketConnection) Connector.open("socket://" + arduinoIP + ":" + arduinoPort);
                server.setSocketOption(SocketConnection.LINGER, 5);

                System.out.println("Socket open");
                break;
            } catch (IOException ex) {
                //ex.printStackTrace();
                try {

                    Thread.sleep(2000);
                } catch (InterruptedException ex1) {
                    ex1.printStackTrace();
                }
            }
        }

        try {
            inputStream = server.openInputStream();
            outputStream = server.openOutputStream();

            //socket.setSocketOption(SocketConnection.LINGER, 0);
            //socket.setSocketOption(SocketConnection.KEEPALIVE, 100);
            //socket.setSocketOption(SocketConnection.RCVBUF, 4096);
            System.out.println("socket option");

            //}
        } catch (IOException ex) {
            System.out.println("Arduino: LOST SERVER!");
            ex.printStackTrace();
        }
        DriverStationLCD.getInstance().updateLCD();

        reader = new InputStreamReader(inputStream);
        buffRead = new BufferedReader(reader);

        System.out.println("buffRead created");

        shouldRunUpdate = true;

        if (updaterunning == false) {
            updaterunning = true;
            new Thread() {
                public void run() {
                    
                    periodicTimer.start();

                    while (shouldRunUpdate) {
                        updateLEDs();
                        // try {
                        // Thread.sleep(2);
                        // System.out.println("update sleep");
                        // } catch (InterruptedException ex1) {
                        // System.out.println("update except");
                        // }
                        //System.out.println("update 2");
                    }
                }
            }.start();
        }

    }

    private void updateLEDs() {

        if (periodicTimer.get() > 1.0) {
            periodicTimer.reset();
            if (outputStream != null) {
                if (pattern != null) {
                    try {
                        outputStream.write(pattern.getBytes());
                        System.out.println("Sending packet");
                        //pattern = null;
                    } catch (IOException z) {
                        System.out.println("Arduino pattern write fail");
                        z.printStackTrace();
                        shouldRunUpdate = false;
                        updaterunning = false;
                        resetNeeded = true;
                    }
                } else {
                    try {
                        outputStream.write("0".getBytes());
                        //outputStream.write(pattern.getBytes());
                    } catch (IOException z) {
                        System.out.println("Arudino write fail");
                        z.printStackTrace();
                        shouldRunUpdate = false;
                        updaterunning = false;
                        outputStream = null;
                        resetNeeded = true;
                    }
                }
            }
        }

        if (buffRead != null) {
            try {
                while (buffRead.ready()) {
                    //System.out.println("buffRead != null");

                    String message;
                    //String message = readString();
                    //System.out.println("readLine");
                    while ((message = buffRead.readLine()) != null) {
                        int len = message.length();
                        for (int i = 0; i < len; i++) {
                            char c = message.charAt(i);
//                            switch (c)
//                            {
//                                case '0':
//                                    break;
//                                case '1':
//                                    break;
//                                case '2':
//                                    break;
//                            }
                            System.out.println(c);
                        }
                    }
                }
            } catch (IOException z) {
                System.out.println("updateLEDs fail");
                z.printStackTrace();
            }
        }
    }

    public synchronized void setPattern(String s) {
        pattern = s;
        System.out.println("setPattern called");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
