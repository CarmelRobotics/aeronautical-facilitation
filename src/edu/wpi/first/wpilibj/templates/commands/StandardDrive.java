
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.AeronauticalFacilitation;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author bradmiller
 */
public class StandardDrive extends CommandBase {

    private Joystick joystick;
    private RobotDrive drive;
    private DriveTrain theDriveTrain;
    private Gyro gyroball;
    
    public StandardDrive(RobotDrive d, Joystick j) {
        super("StandardDrive");
        theDriveTrain = AeronauticalFacilitation.getDriveTrain();
        gyroball = DriveTrain.getGyroball();
        requires(theDriveTrain);
        joystick = j;
        drive = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //DriveTrain.getCommandLog().setCommand(this.getName());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //DriveTrain.getCommandLog().setInputs("" + gyroball.getAngle());
        //DriveTrain.setMetaCommandOutputs();
        theDriveTrain.powerDriveTrain();
        
        theDriveTrain.arcadeDrive(joystick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
