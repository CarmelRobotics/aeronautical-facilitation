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
