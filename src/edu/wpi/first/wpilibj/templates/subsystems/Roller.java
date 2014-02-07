/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2035
 */
public class Roller extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    /**
     *
     */
    public final Solenoid piston;
    //TODO: add another Solenoid

    public final Victor rollermotor;

    /**
     *
     */
    public Roller() {
        rollermotor = new Victor (RobotMap.RollerMotor);  // TODO change number
        piston = new Solenoid(RobotMap.RollSol); // TODO change number
        //TODO: initalize other solenoid  Use RobotMap.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void raiseRoller() {
        piston.set(true);
        //TODO: other solenoid must be set to the opposite
    }

    public void lowerRoller() {
        piston.set(false);
        //TODO: other solenoid must be set to the opposite
    }
     public void setretrievalRoller() {
        rollermotor.set(RobotMap.RollerRetrieval);
        
    }
    public void setRolleroff() {
        rollermotor.set(RobotMap.Rolleroff);
    }
      public void setRelease() {
        rollermotor.set(RobotMap.RollerRelease);
    }

}
