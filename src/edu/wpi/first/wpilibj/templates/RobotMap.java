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
     * DIGITAL SIDECAR PWMS NUMBERING
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
     * DIGITAL SIDECAR DIGITAL INPUTS NUMBERING
     */
    public static final int LauncherSafetyDigitalInput = 2;
    public static final int pressureSwitchDigitalInput = 14;

    /*
     * DIGITAL SIDECAR RELAYS NUMBERING
     */
    public static final int compressorRelay = 3;

    /*
     * SOLENOID RELAY CARTRIDGE NUMBERING
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
    public static final double RollerRetrieval = -1.0; 
    public static final double RollerRelease = 1.0; 
    public static final double Rolleroff = 0.0;

    /*
     * LAUNCHER SUBSYSTEM CONSTANTS
     */
    public static final boolean launchSolenoidValue = true;
    public static final boolean SafetoFire = false;
    public static final boolean launchValve1 = true;
    public static final boolean launchValve2 = true;
    public static final boolean passValve1 = true;
    public static final boolean passValve2 = false;
    public static final boolean retractValve1 = false;
    public static final boolean retractValve2 = false;

    /*
     * DRIVETRAIN SUBSYSTEM CONSTANTS
     */
    public static final boolean shifterLowGear = false;

    /*
     * Joystick objects for driver joystick
     */
    public static final int DriverJoystickNumber = 1;

    /*
     * JOYSTICK BUTTONS
     */
    public static final Joystick dStick = new Joystick(DriverJoystickNumber);
    public static final Joystick dStickII = new Joystick(2);

    public static final JoystickButton dButtonGearShiftLowGear = new JoystickButton(dStick, 1);
    public static final JoystickButton dButtonFeedIn = new JoystickButton(dStick, 2);
    public static final JoystickButton dButtonFeedOut = new JoystickButton(dStick, 3);
    public static final JoystickButton dButtonRollerOut = new JoystickButton(dStick, 4);
    public static final JoystickButton dButtonRollerIn = new JoystickButton(dStick, 5);
    public static final JoystickButton dButtonShoot = new JoystickButton(dStick, 6);
    public static final JoystickButton dButtonPass = new JoystickButton(dStick, 7);

    //public static final JoystickButton dButtonBlkD = new JoystickButton(dStick, 2);
    //public static final JoystickButton dButtonBlkU = new JoystickButton(dStick, 3);
    //public static final JoystickButton dButtonRollerFwd = new JoystickButton(dStick, 4);
    //public static final JoystickButton dButtonRollerLoad = new JoystickButton(dStick, 5);
    //public static final JoystickButton dButtonRollerRelease = new JoystickButton(dStick, 6);
    //public static final JoystickButton dButtonGearShftU = new JoystickButton(dStick, 7);
}
