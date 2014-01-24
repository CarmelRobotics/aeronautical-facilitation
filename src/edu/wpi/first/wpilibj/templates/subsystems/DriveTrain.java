
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.StandardDrive;


/**
 *
 */
public class DriveTrain extends Subsystem {

    private static RobotDrive drive;
    private Talon FrontLeftTalon;
    private Talon FrontRightTalon;
    private Talon RearLeftTalon;
    private Talon RearRightTalon;
    private Solenoid shifter;
    
    public DriveTrain() {
        super("Drive Train");
        
        FrontLeftTalon = new Talon(RobotMap.frontLeftMotor);
        FrontRightTalon = new Talon(RobotMap.frontRightMotor);
        RearLeftTalon = new Talon(RobotMap.rearLeftMotor);
        RearRightTalon = new Talon(RobotMap.rearRightMotor);
        
        drive = new RobotDrive(FrontLeftTalon, FrontLeftTalon, RearLeftTalon, RearLeftTalon);
        
        shifter = new Solenoid(RobotMap.SolenoidShifter);
    }
    
    public void initDefaultCommand() {
        super.setDefaultCommand(new StandardDrive(drive, OI.getDriveStick()));
    }
    
    public void arcadeDrive(Joystick j) {
        drive.arcadeDrive(j.getY(), j.getX());
    }
    
    public void drive(double speed) {
        drive.drive(speed, 0.0);
    }
    
    public RobotDrive getDrive() {
        return drive;
    }
    
    
    public void rotate(double rot) {
        drive.drive(0, rot);
    }
    
    public void shiftLowGear() {
        shifter.set(RobotMap.shifterLowGear);
        System.out.println("Shifting to Low gear");
    }
    
    public void shiftHighGear() {
        shifter.set(RobotMap.shifterHighGear);
        System.out.println("Shifting to High gear");
    }
            
    public void disbleSafety() {
        drive.setSafetyEnabled(false);
    }
    
    public void enableSafety() {
        drive.setSafetyEnabled(true);
    }
    
    public double truncate(double d) {
        int temp = (int)(d*1000);
        double result = (double)temp/1000;
        return result;
    }
}

