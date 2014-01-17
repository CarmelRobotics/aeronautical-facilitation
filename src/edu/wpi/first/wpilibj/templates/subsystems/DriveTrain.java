
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Gyro;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static RobotDrive drive;
    private Talon FrontLeftTalon;
    private Talon FrontRightTalon;
    private Talon RearLeftTalon;
    private Talon RearRightTalon;
    private static Gyro gyroball;

    public DriveTrain() {
        super("Drive Train");
        
        FrontLeftTalon = new Talon(RobotMap.frontLeftMotor);
        FrontRightTalon = new Talon(RobotMap.frontRightMotor);
        RearLeftTalon = new Talon(RobotMap.rearLeftMotor);
        RearRightTalon = new Talon(RobotMap.rearRightMotor);
    }
    
    public static void arcadeDrive(Joystick j) {
        //powerDriveTrain();
        drive.arcadeDrive(j.getY(), j.getX());
    }
    
    public void drive(double speed) {
        //powerDriveTrain();
        drive.drive(speed, 0.0);
    }
    
    public RobotDrive getDrive() {
        return drive;
    }
    
    public void powerDriveTrain() {
        
    }
    
    public static Gyro getGyroball() {
        return gyroball;
    }
    
    public void disbleSafety() {
        drive.setSafetyEnabled(false);
    }
    
    public void enableSafety() {
        drive.setSafetyEnabled(true);
    }
    
    public void initDefaultCommand() {
        //super.setDefaultCommand(new StandardDrive(drive, OI.getDriveStick()));
    }
}

