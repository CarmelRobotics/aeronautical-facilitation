/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2035
 */
public class BlockerArm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay blocker;
    
    public BlockerArm() {
        blocker = new Relay(RobotMap.BlockerMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }

    public void setBlockerRaise() {
        blocker.set(Relay.Value.kForward);
    }

    public void setBlockerLower() {
        blocker.set(Relay.Value.kReverse);

    }
    
    public void setBlockeroff() {
        blocker.set(Relay.Value.kOff);
    }
}
