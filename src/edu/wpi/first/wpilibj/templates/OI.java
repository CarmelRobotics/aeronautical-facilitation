/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.commands.BlockerDown;
import edu.wpi.first.wpilibj.templates.commands.BlockerUp;
import edu.wpi.first.wpilibj.templates.commands.DriveShiftLow;
import edu.wpi.first.wpilibj.templates.commands.Launch;
import edu.wpi.first.wpilibj.templates.commands.LowerRoller;
import edu.wpi.first.wpilibj.templates.commands.Pass;
import edu.wpi.first.wpilibj.templates.commands.RaiseRoller;
import edu.wpi.first.wpilibj.templates.commands.RetrievalRoller;
import edu.wpi.first.wpilibj.templates.commands.SpitoutRoller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    private static Button shiftLowGear;
    private static Button launch;
    //private static Button LoadBall;
    //private static Button ReleaseBall;
    private static Button raiseBlocker;
    private static Button lowerBlocker;
    private static Button lowerRoller;
    private static Button raiseRoller;
    private static Button Pass;
    private static Button retrieve;
    private static Button spitout;
    /**
     *
     */
    public static void initialize() {

        shiftLowGear = RobotMap.dButtonGearShiftLowGear;
        shiftLowGear.whileHeld(new DriveShiftLow());

        launch = RobotMap.dButtonShoot;
        Pass = RobotMap.dButtonPass;
        launch.whenPressed(new Launch());
        Pass.whenPressed(new Pass());
        
        //raiseBlocker = RobotMap.dButtonBlkU;
        //lowerBlocker = RobotMap.dButtonBlkD;
        //raiseBlocker.whileHeld(new BlockerUp());
        //lowerBlocker.whileHeld(new BlockerDown());
        
             
        raiseRoller = RobotMap.dButtonRollerIn;
        lowerRoller = RobotMap.dButtonRollerOut;
        raiseRoller.whenPressed(new RaiseRoller());
        lowerRoller.whenPressed(new LowerRoller());
        
         retrieve = RobotMap.dButtonFeedIn;
         retrieve.whileHeld(new RetrievalRoller());
         
         spitout = RobotMap.dButtonFeedOut;
         spitout.whileHeld(new SpitoutRoller());
         
       
        
    }
   
    /**
     *
     * @return
     */
    public static Joystick getDriveStick() {
        return RobotMap.dStick;
    }
}
