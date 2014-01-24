package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Team 2035
 */
public class Roller extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    /**
     *
     */
    public final Solenoid piston;

    /**
     *
     */
    public final Jaguar motor;

    /**
     *
     */
    public Roller() {
        motor = new Jaguar(1);  // TODO change number
        piston = new Solenoid(1); // TODO change number
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
