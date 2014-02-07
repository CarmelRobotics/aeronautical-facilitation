/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.StandardDrive;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.DriverStationLCD;
/**
 *
 * @author Team 2035
 */
public class DriveTrain extends Subsystem {

    private static RobotDrive drive;
    private static RobotDrive drive6;
    public final Victor FLeftMotor;
    public final Victor BLeftMotor;
    public final Victor FRightMotor;
    public final Victor BRightMotor;
    public final Victor MLeftMotor;
    public final Victor MRightMotor;
    //private final Victor RollerMotor;
    //private final Victor BlockerMotor;
    private final Solenoid GShiftSol;
    //private final Solenoid LFLaunchSol;
    //private final Solenoid RFLaunchSol;
    //private final Solenoid RollSol;
    private static DriverStationLCD display;

    /**
     *
     */
    public DriveTrain() {
        super("DriveTrain");

        FLeftMotor = new Victor(RobotMap.FLeftMotor);
        FRightMotor = new Victor(RobotMap.FRightMotor);
        BLeftMotor = new Victor(RobotMap.BLeftMotor);
        BRightMotor = new Victor(RobotMap.BRightMotor);
        MLeftMotor = new Victor(RobotMap.MLeftMotor);
        MRightMotor = new Victor(RobotMap.MRightMotor);
        
        //RollerMotor = new Victor(RobotMap.RollerMotor);
        //BlockerMotor = new Victor(RobotMap.BlockerMotor);

        drive = new RobotDrive(FLeftMotor, FRightMotor, BLeftMotor, BRightMotor);

        GShiftSol = new Solenoid(RobotMap.GShiftSol);
        //LFLaunchSol = new Solenoid(RobotMap.LFLaunchSol);
        //RollSol = new Solenoid(RobotMap.RollSol);
        //RFLaunchSol = new Solenoid(RobotMap.RFLaunchSol);
    }

    public void initDefaultCommand() {
        super.setDefaultCommand(new StandardDrive(drive, OI.getDriveStick()));
        //super.setDefaultCommand(new StandardDrive(drive6, OI.getDriveStick()));
    }

    /**
     *
     * @param j
     */
    public void arcadeDrive(Joystick j) {
        drive.arcadeDrive(j.getY(), j.getX());
    }

    /**
     *
     * @param speed
     */
    public void drive(double speed) {
        drive.drive(speed, 0.0);
    }
    
    public void drive6(double speed) {
        drive6.drive(speed, 0.0);
    }

    public void drivetank(double speedL, double speedR) {
        drive.tankDrive(speedL, speedR);
    }

    /**
     *
     * @return
     */
    public RobotDrive getDrive() {
        return drive;
    }

    /**
     *
     * @param rot
     */
    public void rotate(double rot) {
        drive.drive(0, rot);
    }

    /**
     *
     */
    public void shiftLowGear() {
        GShiftSol.set(RobotMap.shifterLowGear);
        //System.out.println("Shifting to Low gear");
        display.println(Line.kUser1, 1, "Into Low Gear");
        display.updateLCD();
    }

    /**
     *
     */
    public void shiftHighGear() {
        GShiftSol.set(RobotMap.shifterHighGear);
        //System.out.println("Shifting to High gear");
        display.println(Line.kUser1, 1, "Into High Gear");
        display.updateLCD();
    }

    /**
     *
     */
    public void disbleSafety() {
        drive.setSafetyEnabled(false);
        display.println(Line.kUser1, 1, "Safety Disabled");
        display.updateLCD();
    }

    /**
     *
     */
    public void enableSafety() {
        drive.setSafetyEnabled(true);
        display.println(Line.kUser1, 1, "Safety Enabled");
        display.updateLCD();
    }

    /**
     *
     * @param d
     * @return
     */
    public double truncate(double d) {
        int temp = (int) (d * 1000);
        double result = (double) temp / 1000;
        return result;
    }
}
