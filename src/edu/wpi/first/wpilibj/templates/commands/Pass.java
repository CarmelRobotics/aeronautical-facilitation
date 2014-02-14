/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.Launcher;
import edu.wpi.first.wpilibj.templates.AeronauticalFacilitation;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2035
 */
public class Pass extends CommandBase {

    private final Launcher launcher;
    
    private final DriverStationLCD display;
    private static int counter = 0;
    private Timer delayTimer;
    /**
     *
     */
    public Pass() {
        super("Pass");
        launcher = AeronauticalFacilitation.getLauncher();
        requires(launcher);
        display = DriverStationLCD.getInstance();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        counter++;
        delayTimer = RobotMap.ShooterDelayTimer;
        delayTimer.start();
        display.println(DriverStationLCD.Line.kUser2, 1, "Pass command " + counter + "                    ");
        display.updateLCD();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.pass();
        display.println(DriverStationLCD.Line.kUser3, 1, "Pass timer: " + delayTimer.get() + "      ");
        display.updateLCD();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (delayTimer.get() > 2.0) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.retract();
        display.println(DriverStationLCD.Line.kUser2, 1, "Pass command ended  " + counter + "     ");
        display.updateLCD();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        launcher.retract();
    }
}
