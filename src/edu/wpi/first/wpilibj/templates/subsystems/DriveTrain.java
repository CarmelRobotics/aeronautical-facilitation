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
import edu.wpi.first.wpilibj.templates.commands.StandardDrive;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author Team 2035
 */
public class DriveTrain extends Subsystem {

    private final RobotDrive drive;
    private final RobotDrive drive6;
    private final Victor FLeftMotor;
    private final Victor BLeftMotor;
    private final Victor FRightMotor;
    private final Victor BRightMotor;
    private final Victor MLeftMotor;
    private final Victor MRightMotor;
    private final Solenoid GShiftSolDown;
    private final Solenoid GShiftSolUp;
    private final DriverStationLCD display;

    /**
     *
     */
    public DriveTrain() {
        super("DriveTrain");

        FLeftMotor = new Victor(RobotMap.FLeftMotorPWM);
        FRightMotor = new Victor(RobotMap.FRightMotorPWM);
        BLeftMotor = new Victor(RobotMap.BLeftMotorPWM);
        BRightMotor = new Victor(RobotMap.BRightMotorPWM);
        MLeftMotor = new Victor(RobotMap.MLeftMotorPWM);
        MRightMotor = new Victor(RobotMap.MRightMotorPWM);
        drive = new RobotDrive(FLeftMotor, BLeftMotor, FRightMotor, BRightMotor);
        //drive6 = new RobotDrive(FLeftMotor, BLeftMotor, FRightMotor, BRightMotor, MLeftMotor, MRightMotor);
        drive6 = new RobotDrive(MLeftMotor, MRightMotor);
        //^Won't take 6 paramaters?
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

        GShiftSolDown = new Solenoid(RobotMap.DriveTrainLowGearSolenoid);
        GShiftSolUp = new Solenoid(RobotMap.DriveTrainHighGearSolenoid);
        display = DriverStationLCD.getInstance();
    }

    public void initDefaultCommand() {
        super.setDefaultCommand(new StandardDrive(drive, RobotMap.DriverJoystick));
        
    }

    /**
     *
     * @param j
     */
    public void arcadeDrive(Joystick j) {
        drive.arcadeDrive(j.getY(), j.getX());
        drive6.arcadeDrive(j.getY(), j.getX());
    }

    /**
     *
     * @param speed
     */
    public void drive(double speed) {
        drive.drive(speed, 0.0);
        drive6.drive(speed, 0.0);
    }

    /*public void drive6(double speed) {
        drive6.drive(speed, 0.0);
        drive.drive(speed, 0.0);
    
    }*/

    public void drivetank(double speedL, double speedR) {
        drive.tankDrive(speedL, speedR);
        drive6.tankDrive(speedL, speedR);
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
        drive6.drive(0, rot);
    }

    /**
     *
     */
    public void shiftLowGear() {
        GShiftSolUp.set(!RobotMap.DriveTrainLowGearSolenoidValue);
        GShiftSolDown.set(RobotMap.DriveTrainLowGearSolenoidValue);
        GShiftSolUp.set(false);
        GShiftSolDown.set(true);
        display.println(Line.kUser1, 1, "Into Low Gear ");
        display.updateLCD();
    }

    /**
     *
     */
    public void shiftHighGear() {
        GShiftSolUp.set(!RobotMap.DriveTrainLowGearSolenoidValue);
        GShiftSolDown.set(RobotMap.DriveTrainLowGearSolenoidValue);
        GShiftSolUp.set(true);
        GShiftSolDown.set(false);

        display.println(Line.kUser1, 1, "Into High Gear ");
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
