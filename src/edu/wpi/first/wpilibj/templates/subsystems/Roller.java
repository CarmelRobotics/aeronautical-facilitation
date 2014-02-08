/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

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
    public final Solenoid extendPiston;
    public final Solenoid retractPiston;
    //TODO: add another Solenoid DONE

    public final Victor rollermotor;

    /**
     *
     */
    public Roller() {
        rollermotor = new Victor (RobotMap.RollerMotor);
        extendPiston = new Solenoid(RobotMap.ExtSol);
        retractPiston = new Solenoid(RobotMap.RetSol);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void raiseRoller() {
        extendPiston.set(true);
        retractPiston.set(false);
    }

    public void lowerRoller() {
        extendPiston.set(false);
        retractPiston.set(true);
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
