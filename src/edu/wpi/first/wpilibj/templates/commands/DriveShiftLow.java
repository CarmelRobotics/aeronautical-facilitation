/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.AeronauticalFacilitation;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author Team 2035
 */
public class DriveShiftLow extends CommandBase {

    private final DriveTrain theDriveTrain;

    public DriveShiftLow() {
        super("StandardDrive");
        theDriveTrain = AeronauticalFacilitation.getDriveTrain();
        //requires(theDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        theDriveTrain.shiftLowGear();
        //DriveTrain.getCommandLog().setCommand(this.getName());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //DriveTrain.getCommandLog().setInputs("" + gyroball.getAngle());
        //DriveTrain.setMetaCommandOutputs();
        theDriveTrain.shiftLowGear();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        theDriveTrain.shiftHighGear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        theDriveTrain.shiftHighGear();
    }
}
