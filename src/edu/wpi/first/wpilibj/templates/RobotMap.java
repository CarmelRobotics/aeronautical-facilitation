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

    /*
     * DIGITAL SIDECAR PWMS NUMBERING (can be 1-10)
     */
    public static final int FLeftMotorPWM = 1;
    public static final int BLeftMotorPWM = 2;
    public static final int FRightMotorPWM = 3;
    public static final int BRightMotorPWM = 4;
    public static final int RollerMotorPWM = 5;
    public static final int MRightMotorPWM = 6;
    public static final int MLeftMotorPWM = 7;
    public static final int BlockerMotorPWM = 8;

    /*
     * DIGITAL SIDECAR DIGITAL INPUTS NUMBERING (can be 1-14)
     */
    public static final int LauncherSafetyDigitalInput = 2;
    public static final int PressureSwitchDigitalInput = 14;

    /*
     * DIGITAL SIDECAR RELAYS NUMBERING (can be 1-8)
     */
    public static final int CompressorRelay = 5;

    /*
     * SOLENOID RELAY CARTRIDGE NUMBERING (can be 1-8)
     */
    public static final int LaunchRightSolenoid = 2;
    public static final int DriveTrainHighGearSolenoid = 3;
    public static final int DriveTrainLowGearSolenoid = 4;

    public static final int LaunchLeftSolenoid = 6;
    public static final int RollerExtensionSolenoid = 7;
    public static final int RollerRetractSolenoid = 8;

    /*
     * BLOCKER SUBSYSTEM CONSTANTS
     */
    public static final Relay.Value RaiseBlockerMotor = Relay.Value.kForward;
    public static final Relay.Value LowerBlockerMotor = Relay.Value.kReverse;
    public static final Relay.Value blocker = Relay.Value.kOff;

    /*
     * ROLLER SUBSYSTEM CONSTANTS
     */
    public static final double RollerRetrievalMotorSpeed = -1.0;
    public static final double RollerReleaseMotorSpeed = 1.0;
    public static final double RollerOffMotorSpeed = 0.0;

    /*
     * LAUNCHER SUBSYSTEM CONSTANTS
     */
    public static final boolean LaunchSolenoidValue = true;
    public static final boolean SafetoFire = false;

    /*
     * DRIVETRAIN SUBSYSTEM CONSTANTS
     */
    public static final boolean DriveTrainLowGearSolenoidValue = false;
    public static final double AutonomousSpeed = 0.40;

    /*
     * The Joystick USB number (can be 1-4)
     */
    public static final int DriverJoystickUSBNumber = 1;

    /*
     * JOYSTICK BUTTONS
     */
    public static final Joystick DriverJoystick = new Joystick(DriverJoystickUSBNumber);
    public static final Joystick AlternateJoystick = new Joystick(2);

    public static final JoystickButton ButtonDriveTrainShiftToLowGear = new JoystickButton(DriverJoystick, 1);
    public static final JoystickButton ButtonRollerRetrieveBall = new JoystickButton(DriverJoystick, 2);
    public static final JoystickButton ButtonRollerReleaseBall = new JoystickButton(DriverJoystick, 3);
    public static final JoystickButton ButtonRollerExtend = new JoystickButton(DriverJoystick, 4);
    public static final JoystickButton ButtonRollerRetract = new JoystickButton(DriverJoystick, 5);
    public static final JoystickButton ButtonLaunchBall = new JoystickButton(DriverJoystick, 6);
    public static final JoystickButton ButtonPassBall = new JoystickButton(DriverJoystick, 7);

    //public static final JoystickButton dButtonBlkD = new JoystickButton(dStick, 2);
    //public static final JoystickButton dButtonBlkU = new JoystickButton(dStick, 3);
    //public static final JoystickButton dButtonRollerFwd = new JoystickButton(dStick, 4);
    //public static final JoystickButton dButtonRollerLoad = new JoystickButton(dStick, 5);
    //public static final JoystickButton dButtonRollerRelease = new JoystickButton(dStick, 6);
    //public static final JoystickButton dButtonGearShftU = new JoystickButton(dStick, 7);
}
