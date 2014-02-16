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
import edu.wpi.first.wpilibj.templates.commands.Autonomous;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;

public class AeronauticalFacilitation extends IterativeRobot {

    Command autonomousCommand;
    private static DriveTrain DriveTrain;
    private static Launcher launchercontroller;
    private static BlockerArm blockercontroller;
    private static Roller rollerSubsystem;
    private static DriverStationLCD display;
    private static Compressor compressor;
    public static ArduinoConnection arduino;
    private int pattern;
    public static DriverStation driverStation;
    private boolean digital1;
    private boolean digital2;
    private boolean digital3;
    private int alliance;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code. This declares all of the hardware on
     * the robot that will be used in the javadoc.
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
    
    public static ArduinoConnection getArduino() {
        return arduino;
    }

    /**
     *
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        DriveTrain = new DriveTrain();
        launchercontroller = new Launcher();
        rollerSubsystem = new Roller();
        blockercontroller = new BlockerArm();
        display = DriverStationLCD.getInstance();
        compressor = new Compressor(RobotMap.PressureSwitchDigitalInput, RobotMap.CompressorRelay);
        compressor.start();
        
        DriveTrain.shiftHighGear();

        OI.initialize();

        autonomousCommand = new Autonomous();
        
        arduino = new ArduinoConnection();
        arduino.setPattern("0");
        pattern = 0;
        driverStation = DriverStation.getInstance();
        alliance = driverStation.getAlliance().value;
        digital1 = driverStation.getDigitalIn(1);
        digital2 = driverStation.getDigitalIn(2);
        digital3 = driverStation.getDigitalIn(3);

        // Initialize all subsystems.
        // Subsystems: a self-contained system within a larger system. 
        CommandBase.init();
    }

    /**
     *
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
        // 
        autonomousCommand.start();
        //System.out.println("Entering Autonomous....");
        display.println(Line.kUser1, 1, "Autonomous");
        display.updateLCD();

    }

    /**
     * This function is called periodically (at regular intervals of time)
     * during autonomous period.
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
        if (alliance == 0) {
            arduino.setPattern("1");
            pattern = 1;
        } else if (alliance == 1){
            arduino.setPattern("2");
            pattern = 2;
        } else {
            arduino.setPattern("0");
            pattern = 0;
        }
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void disabledPeriodic() {
        display.println(Line.kUser1, 1, "Lauch: " + launchercontroller.launcherswitch());
        display.updateLCD();
        digital1 = driverStation.getDigitalIn(1);
        digital2 = driverStation.getDigitalIn(2);
        digital3 = driverStation.getDigitalIn(3);
        alliance = driverStation.getAlliance().value;
        if (digital1 == true && digital2 == false && digital3 == false) {
            arduino.setPattern("4");
            pattern = 1;
        } else if (digital2 == true && digital1 == false && digital3 == false) {
            arduino.setPattern("5");
            pattern = 5;
        } else if (digital3 == true && digital1 == false && digital2 == false) {
            arduino.setPattern("6");
            pattern = 6;
        } else {
            arduino.setPattern("0");
            pattern = 0;
        }
        
    }
}