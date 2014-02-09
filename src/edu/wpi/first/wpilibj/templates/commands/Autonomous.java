/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.AeronauticalFacilitation;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.Launcher;

/**
 *
 * @author Team 2035
 */
public class Autonomous extends CommandBase {

    private final DriveTrain drive;
    private final Launcher launcher;
    private Timer autonomousTimer;
    private final double MotorsOnSpeed = RobotMap.AutonomousSpeed;
    private final double MotorsOffSpeed = 0.0;
    private double storedTime;

    /**
     *
     */
    public Autonomous() {
        super("drive");
        drive = AeronauticalFacilitation.getDriveTrain();
        launcher = AeronauticalFacilitation.getLauncher();
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        autonomousTimer = new Timer();
        autonomousTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double currentTime = autonomousTimer.get();
        if (currentTime > 0.0 && currentTime < 1.5) {
            drive.drivetank(MotorsOnSpeed, MotorsOnSpeed);
        } else if (currentTime > 1.5 && currentTime < 6.0) {
            launcher.launch();
            storedTime = autonomousTimer.get();
            //r.start();
            drive.drivetank(MotorsOffSpeed, MotorsOffSpeed);
        }
        if (currentTime > storedTime + 5.0) {
            launcher.retract();
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (autonomousTimer.get() > 10.0) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        launcher.retract();
    }
}
