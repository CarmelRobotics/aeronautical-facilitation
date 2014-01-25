/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Team 2035
 */
public class Launcher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid launcher;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     *
     */
    public Launcher() {
        launcher = new Solenoid(5);
    }

    /**
     *
     * @param on
     */
    public void setLauncherSolenoid(boolean on) {
        launcher.set(on);
    }
}