/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.AeronauticalFacilitation;
import edu.wpi.first.wpilibj.templates.subsystems.Roller;

/**
 *
 * @author Team 2035
 */
public class RollerRelease extends CommandBase {

    private final Roller roller;

    /**
     *
     */
    public RollerRelease() {
        super("rollerrelease");
        roller = AeronauticalFacilitation.getRoller();
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        roller.setRelease();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

        roller.setRolleroff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        roller.setRolleroff();
    }
}
