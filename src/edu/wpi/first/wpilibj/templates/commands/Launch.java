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
public class Launch extends CommandBase {

    private final Launcher launcher;
    //TODO: add Roller subsystem here.
    private Timer delayTimer;
    private final DriverStationLCD display;
    private static int counter = 0;

    /**
     *
     */
    public Launch() {
        super("Launch");
        launcher = AeronauticalFacilitation.getLauncher();
        requires(launcher);

        display = DriverStationLCD.getInstance();
        //TODO: add roller = here
        //TODO: add requires(roller) here
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        counter++;
        delayTimer = RobotMap.ShooterDelayTimer;
        delayTimer.start();
        //TODO: use roller subsystem to lower the roller.
        display.println(DriverStationLCD.Line.kUser2, 1, "lauch command " + counter + "                  ");
        display.updateLCD();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.launch();
        display.println(DriverStationLCD.Line.kUser3, 1, "Lauch timer: " + delayTimer.get() + "        ");
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
        display.println(DriverStationLCD.Line.kUser2, 1, "Launch command ended " + counter + "         ");
        display.updateLCD();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        launcher.retract();
    }
}
