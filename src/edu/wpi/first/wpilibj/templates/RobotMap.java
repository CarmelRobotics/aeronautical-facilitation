/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    /*
     * DIGITAL SIDECAR
     */
    /**
     *
     */
    public static final int FLeftMotor = 1;

    public static final int BLeftMotor = 2;

    public static final int FRightMotor = 3;

    public static final int BRightMotor = 4;
    
    public static final int MLeftMotor = 7;
    
    public static final int MRightMotor = 6;
    
    public static final int RollerMotor = 5;

    public static final int BlockerMotor = 8;
    
    /** The pressure switch that provides feedback to the compressor to turn off when the system reaches 60 PSI. */
    public static final int pressureSwitch = 14;

    public static final int compressorRelay = 3;

    public static final Relay.Value RaiseBlockerMotor = Relay.Value.kForward;

    public static final Relay.Value LowerBlockerMotor = Relay.Value.kReverse;

    public static final Relay.Value blocker = Relay.Value.kOff;

    public static final double RollerRetrieval = 0.25;

    public static final double RollerRelease = -0.25;

    public static final double Rolleroff = 0;
    
    public static final boolean launchSolenoidValue = true;
    
    public static final int LauncherSafetyDigitalInput = 2;
    
    public static final boolean SafetoFire = false;
    

    /*public static final Relay.Value retrieveMotor = Relay.Value.kForward;
    
     public static final Relay.Value spinOut = Relay.Value.kReverse;

     public static final Relay.Value rollerOff = Relay.Value.kOff;
    
     public static final Relay.Value rollerOn = Relay.Value.kOn;*/
    //public static final int AnalogSidecar = 1; // Analog sidecar p
    //public static final int AnalogSidecar = 1; // Analog sidecar possibly connected to cRIO Slot 1, check later
    //public static final int DigitalSidecar = 2; // Digital possibly connected to Slot 2, check later
    //public static final int DriveTrainGyroInput = 1; // Gyro Analog input is on channel 1
    //private static boolean JoystickEnabled = true;
    /**
     * Joystick objects for driver joystick
     */
    public static final int DriverJoystickNumber = 1;

    /**
     *
     */
    public static final Joystick dStick = new Joystick(DriverJoystickNumber);
    public static final Joystick dStickII = new Joystick(2);

    /**
     *
     */
    public static final JoystickButton dButtonLaunch = new JoystickButton(dStick, 1);

    /**
     *
     */
    public static final JoystickButton dButtonBlkD = new JoystickButton(dStick, 2);

    /**
     *
     */
    public static final JoystickButton dButtonBlkU = new JoystickButton(dStick, 3);

    /**
     *
     */
    //public static final JoystickButton dButtonRollerFwd = new JoystickButton(dStick, 4);
    //public static final JoystickButton dButtonRollerLoad = new JoystickButton(dStick, 5);
    /**
     *
     */
    //public static final JoystickButton dButtonRollerRelease = new JoystickButton(dStick, 6);
    /**
     *
     */
    public static final JoystickButton dButtonGearShftU = new JoystickButton(dStick, 7);

    /**
     *
     */
    public static final JoystickButton dButtonGearShftD = new JoystickButton(dStick, 8);

    public static final JoystickButton dButtonPass = new JoystickButton(dStick, 9);

    public static final JoystickButton dButtonLowerRoll = new JoystickButton(dStickII, 3);

    public static final JoystickButton dButtonRaiseRoll = new JoystickButton(dStickII, 4);

    public static final JoystickButton dButtonRetrieve = new JoystickButton(dStickII, 1);

    public static final JoystickButton dButtonOut = new JoystickButton(dStickII, 2);
    //public static final boolean shifterDriveTrainDirection = false;
    /* 
     * SOLENOIDS
     */
    /**
     *
     */
    public static final boolean shifterLowGear = false;

    public static final int GShiftSolDown = 4;
    
    public static final int GShiftSolUp = 3;
    
    public static final int RFLaunchSol = 2;

    public static final int LFLaunchSol = 6;

    public static final int ExtSol = 7; 
    
    public static final int RetSol = 8;
    

    public static final boolean launchValve1 = true;

    public static final boolean launchValve2 = true;

    public static final boolean passValve1 = true;

    public static final boolean passValve2 = false;

    public static final boolean retractValve1 = false;

    public static final boolean retractValve2 = false;

}
