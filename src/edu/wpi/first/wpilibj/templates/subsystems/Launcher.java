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

/**
 *
 * @author Team 2035
 */
public class Launcher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid launcherL;
    Solenoid launcherR;

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
        launcherL.set(true);
        launcherR.set(true);
    }
    
    public void pass() {
        launcherL.set(true);
        launcherR.set(false);
    }
    
    public void retract() {
        launcherL.set(false);
        launcherR.set(false);
    }
}
