/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 * @author Team 2035
 */
public class Autonomous2 extends CommandGroup {

    /** Steps:
     * 1: drive forward 1 sec
     * 2: stop driving
     * 3: check to see if target is in aligned properly
     * 3.5: if target is aligned properly #GOTO BRANCH 1
     * 4: if target is in range and not aligned, align properly #goto BRANCH 1
     * 5: if target is no longer in range #GOTO BRANCH 2
     * BRANCH 1:
     * 1: wait .2 sec
     * 2: extend roller
     * 3: wait .35 sec
     * 4: launch ball
     * 5: wait .35 sec
     * 6: retract roller
     * BRANCH 2:
     * 1: turn to search for target in range
     * 2: when target is found, align properly
     * 3: #GOTO BRANCH 1
     */
    public Autonomous2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new Auto_Prepare());
        addSequential(new Auto_Shoot());
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
