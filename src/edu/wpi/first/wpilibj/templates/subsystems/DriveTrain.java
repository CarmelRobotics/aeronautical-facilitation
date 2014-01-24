
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
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static RobotDrive drive;
    private Talon FrontLeftTalon;
    private Talon FrontRightTalon;
    private Talon RearLeftTalon;
    private Talon RearRightTalon;
    private static Gyro gyroball;
    private Solenoid powerTakeOff;
    private Solenoid shifter;
    
    public DriveTrain() {
        super("Drive Train");
        
        FrontLeftTalon = new Talon(RobotMap.frontLeftMotor);
        FrontRightTalon = new Talon(RobotMap.frontRightMotor);
        RearLeftTalon = new Talon(RobotMap.rearLeftMotor);
        RearRightTalon = new Talon(RobotMap.rearRightMotor);
        gyroball = new Gyro(RobotMap.AnalogSidecar, RobotMap.DriveTrainGyroInput);
        drive = new RobotDrive(FrontLeftTalon, FrontLeftTalon, RearLeftTalon, RearLeftTalon);
    }
    
    public void initDefaultCommand() {
        super.setDefaultCommand(new StandardDrive(drive, OI.getDriveStick()));
    }
    
    public void arcadeDrive(Joystick j) {
        powerDriveTrain();
        drive.arcadeDrive(j.getY(), j.getX());
    }
    
    public void drive(double speed) {
        powerDriveTrain();
        drive.drive(speed, 0.0);
    }
    
    public RobotDrive getDrive() {
        return drive;
    }
    
    public void powerDriveTrain() {
        System.out.println("Shifting the gears BRO");
        powerTakeOff.set(RobotMap.shifterDriveTrainDirection);
    }
    
    public static Gyro getGyroball() {
        return gyroball;
    }
    
    public void rotate(double rot) {
        powerDriveTrain();
        drive.drive(0, rot);
    }
    
    public void shiftLowGear() {
        shifter.set(RobotMap.shifterLowGear);
    }
    
    public void shiftHighGear() {
        shifter.set(RobotMap.shifterHighGear);
        System.out.println("Shiftin Them Gears HIGH");
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

