/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
/**
 *
 * @author Team 2035
 */
public class Launcher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid launcherL;
    Solenoid launcherR;
    Compressor compress;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     *
     */
    public Launcher() {
        launcherL = new Solenoid(RobotMap.LFLaunchSol);
        launcherR = new Solenoid(RobotMap.RFLaunchSol);
        compress = new Compressor(RobotMap.pressureSwitch, RobotMap.compressorRelay);
        compress.start();
    }
    

    /**
     *
     * @param value
     */
    public void setLauncherSolenoid(boolean value) {
        launcherL.set(value);
        launcherR.set(value);

    }

    public void launch() {
        launcherL.set(RobotMap.launchSolenoidValue);
        launcherR.set(RobotMap.launchSolenoidValue);
    }

    public void pass() {
        launcherL.set(RobotMap.launchSolenoidValue);
        launcherR.set(!RobotMap.launchSolenoidValue);
    }

    public void retract() {
        launcherL.set(!RobotMap.launchSolenoidValue);
        launcherL.set(!RobotMap.launchSolenoidValue);
     
    }
}
