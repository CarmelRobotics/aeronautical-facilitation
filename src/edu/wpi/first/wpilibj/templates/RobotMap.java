/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
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
    public static final int FLeftMotorPWM = 1; // Front Left drive motor is wired to PWM out 1
    public static final int BLeftMotorPWM = 2; // Rear Left drive motor is wired to PWM out 2
    public static final int FRightMotorPWM = 3; // Front Right drive motor is wired to PWM out 3
    public static final int BRightMotorPWM = 4; // Rear Right drive motor is wired to PWM out 4 
    public static final int RollerMotorPWM = 5; // Roller motor is wired to PWM out 5
    public static final int MRightMotorPWM = 6; // Middle Right drive motor is set to PWM out 6
    public static final int MLeftMotorPWM = 7; // Middle Left drive motor is set to PWM out 7

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
    public static final int LaunchRightSolenoid = 2; // Right Launcher solenoid is set to relay cartridge 2
    public static final int DriveTrainHighGearSolenoid = 3; // Drive Train High Gear is set to relay cartridge 3
    public static final int DriveTrainLowGearSolenoid = 4; // Drive Train Low Gear is set to relay cartridge 4

    public static final int LaunchLeftSolenoid = 6; // Left Launcher solenoid is set to relay cartridge 6
    public static final int RollerExtensionSolenoid = 7; // Roller extension solenoid relay cartridge 7
    public static final int RollerRetractSolenoid = 8; // Roller retraction solenoid is set to 8

    /*
     * ROLLER SUBSYSTEM CONSTANTS
     */
    public static final double RollerRetrievalMotorSpeed = -1.0; // Roller motor retreive speed is set to reverse 100%
    public static final double RollerReleaseMotorSpeed = 1.0; // Roller motor release speed is set to forward 100%
    public static final double RollerOffMotorSpeed = 0.0; // Roller motor stationary is set to 0%

    /*
     * LAUNCHER SUBSYSTEM CONSTANTS
     */
    public static final boolean LaunchSolenoidValue = true;
    public static final boolean SafetoFire = true;

    /*
     * DRIVETRAIN SUBSYSTEM CONSTANTS
     */
    public static final boolean DriveTrainLowGearSolenoidValue = false;
    public static final double AutonomousSpeed = 0.40; // Autonomous speed set to 40%

    /*
     * The Joystick USB number (can be 1-4)
     */
    public static final int DriverJoystickUSBNumber = 1;

    /*
     * JOYSTICK BUTTONS
     */
    public static final Joystick DriverJoystick = new Joystick(DriverJoystickUSBNumber);
    public static final Joystick AlternateJoystick = new Joystick(2);

    public static final JoystickButton ButtonDriveTrainShiftToLowGear = new JoystickButton(DriverJoystick, 1); // Hold button 1 to shift lower gear
    public static final JoystickButton ButtonRollerRetrieveBall = new JoystickButton(DriverJoystick, 2); // Hold button 2 to activate roller
    public static final JoystickButton ButtonRollerReleaseBall = new JoystickButton(DriverJoystick, 3); // Hold button 3 to recerse roller
    public static final JoystickButton ButtonRollerExtend = new JoystickButton(DriverJoystick, 4); // Hold button 4 to extend roller
    public static final JoystickButton ButtonRollerRetract = new JoystickButton(DriverJoystick, 5); // Hold button 5 to retract roller
    public static final JoystickButton ButtonLaunchBall = new JoystickButton(DriverJoystick, 6); // Hold button 6 to launch ball # 2 solenoids
    public static final JoystickButton ButtonPassBall = new JoystickButton(DriverJoystick, 7); // Hold button 7 to pass ball # 1 solenoid

    //public static final JoystickButton dButtonBlkD = new JoystickButton(dStick, 2);
    //public static final JoystickButton dButtonBlkU = new JoystickButton(dStick, 3);
    //public static final JoystickButton dButtonRollerFwd = new JoystickButton(dStick, 4);
    //public static final JoystickButton dButtonRollerLoad = new JoystickButton(dStick, 5);
    //public static final JoystickButton dButtonRollerRelease = new JoystickButton(dStick, 6);
    //public static final JoystickButton dButtonGearShftU = new JoystickButton(dStick, 7);
    
    public static Timer ShooterDelayTimer = new Timer();
}
