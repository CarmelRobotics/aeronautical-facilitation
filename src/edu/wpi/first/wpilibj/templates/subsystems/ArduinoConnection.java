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
    
    SocketConnection server;
    InputStream inputStream;
    InputStreamReader reader;
    BufferedReader buffRead;
    OutputStream outputStream;
    
    Thread connect;
    
    String arduinoIP = "10.20.35.12";
    String arduinoPort = "1140";
    
    boolean updaterunning = false;
    Timer periodicTimer;
    String pattern;
    
    public ArduinoConnection() {
        pattern = null;
        connect = new Thread() {
            public void run() {
                arduinoConnection();
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
        if (updaterunning == false) {
            updaterunning = true;
            new Thread() {
                public void run() {
                    periodicTimer = new Timer();
                    periodicTimer.start();
                    
                    while (true) {
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
        
        if (periodicTimer.get() > 0.5) {
            periodicTimer.reset();
            try {
                outputStream.write("0".getBytes());
            } catch (IOException z) {
                System.out.println("Arudino write fail");
                z.printStackTrace();
            }
            
        }
        
        if (pattern != null) {
            try {
                outputStream.write(pattern.getBytes());
                pattern = null;
            } catch (IOException z) {
                System.out.println("Arduino pattern write fail");
                z.printStackTrace();
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
    
    public void setPattern(String s) {
        pattern = s;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
