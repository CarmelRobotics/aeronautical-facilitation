
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Joystick;


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

    public DriveTrain() {
        super("Drive Train");
        
        FrontLeftTalon = new Talon(RobotMap.frontLeftMotor);
        FrontRightTalon = new Talon(RobotMap.frontRightMotor);
        RearLeftTalon = new Talon(RobotMap.rearLeftMotor);
        RearRightTalon = new Talon(RobotMap.rearRightMotor);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

