/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2035
 */
public class Launcher extends Subsystem {

    private final Solenoid launcherLeft;
    private final Solenoid launcherRight;
    DigitalInput launcherSafetySwitch;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     *
     */
    public Launcher() {
        launcherLeft = new Solenoid(RobotMap.LaunchLeftSolenoid);
        launcherRight = new Solenoid(RobotMap.LaunchRightSolenoid);
        launcherSafetySwitch = new DigitalInput(RobotMap.LauncherSafetyDigitalInput);
    }

    /**
     *
     * @param value
     */
    public void setLauncherSolenoid(boolean value) {
        launcherLeft.set(value);
        launcherRight.set(value);

    }

    public void launch() {
        if (launcherSafetySwitch.get() == RobotMap.SafetoFire) {
            launcherLeft.set(RobotMap.LaunchSolenoidValue);
            launcherRight.set(RobotMap.LaunchSolenoidValue);
        } else if (launcherSafetySwitch.get() != RobotMap.SafetoFire) {
            launcherLeft.set(!RobotMap.LaunchSolenoidValue);
            launcherRight.set(!RobotMap.LaunchSolenoidValue);
        }
    }

    public void pass() {
        if (launcherSafetySwitch.get() == RobotMap.SafetoFire) {
            launcherLeft.set(RobotMap.LaunchSolenoidValue);
            launcherRight.set(!RobotMap.LaunchSolenoidValue);
        } else if (launcherSafetySwitch.get() != RobotMap.SafetoFire) {
            launcherLeft.set(!RobotMap.LaunchSolenoidValue);
            launcherRight.set(!RobotMap.LaunchSolenoidValue);
        }
    }

    public void retract() {
        launcherLeft.set(!RobotMap.LaunchSolenoidValue);
        launcherRight.set(!RobotMap.LaunchSolenoidValue);

    }

    public boolean launcherswitch() {
        return launcherSafetySwitch.get();

    }

}
