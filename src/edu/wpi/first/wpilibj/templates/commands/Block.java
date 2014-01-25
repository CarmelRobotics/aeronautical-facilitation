/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.AeronauticalFacilitation;
import edu.wpi.first.wpilibj.templates.subsystems.BlockerArm;

/**
 *
 * @author Team 2035
 */
public class Block extends CommandBase {

    private BlockerArm block;

    /**
     *
     */
    public Block() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("Block");
        block = AeronauticalFacilitation.getBlockerArm();
        requires(block);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
