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
import edu.wpi.first.wpilibj.templates.subsystems.Launcher;

/**
 *
 * @author Team 2035
 */
public class Autonomous extends CommandBase {

    private DriveTrain drive;
    private Launcher launcher;
    private Timer t;
    private Timer r;
    private double SpeedL = 0.25;
    private double SpeedR = 0.25;
    private double MotorSpeed = 0.0;
    private double t2;

    /**
     *
     */
    public Autonomous() {
        super("drive");
        drive = AeronauticalFacilitation.getDriveTrain();
        launcher = AeronauticalFacilitation.getLauncher();
        requires(drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        t = new Timer();
        //r = new Timer();
        t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double tv = t.get();
        //double tc = r.get();
        if (tv > 0.0 && tv < 3.0) {
            drive.getDrive();
            drive.drivetank(SpeedL, SpeedR);
            // put stuff that the robot is going to do here TODO
            // THIS IS A BLANK LINE PLACEHOLDER!
        } else if (tv > 3.0 && tv < 6.0) {
            launcher.launch();
            double t2 = t.get();
            //r.start();
            drive.drivetank(MotorSpeed, MotorSpeed);
        }
        if (tv > t2 + 5.0) {
            launcher.retract();
        }
        
           //
        // THIS IS A BLANK LINE PLACEHOLDER!

//        drive.getDrive();
//        drive.drivetank(SpeedL, SpeedR);
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (t.get() > 10.0) {
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
