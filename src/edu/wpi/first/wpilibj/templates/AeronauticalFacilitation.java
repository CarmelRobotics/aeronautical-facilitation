/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class AeronauticalFacilitation extends IterativeRobot {

    Command autonomousCommand;
    private static DriveTrain DriveTrain;
    private static Launcher launchercontroller;
    private static BlockerArm blockercontroller;
    private static Roller rollerSubsystem;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     *
     * @return
     */
    public static DriveTrain getDriveTrain() {
        return DriveTrain;
    }
    
    public static Roller getRoller() {
        return rollerSubsystem;
    }

    public static Launcher getLauncher() {
        return launchercontroller;
    }

    public static BlockerArm getBlockerArm() {
        return blockercontroller;
    }

    /**
     *
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
<<<<<<< HEAD
        DriveTrain = new DriveTrain();
        launchercontroller = new Launcher();
=======
        rollerSubsystem = new Roller();
>>>>>>> refs/remotes/origin/feature-roller

        // Initialize all subsystems
        CommandBase.init();
    }

    /**
     *
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     *
     */
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
