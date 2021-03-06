/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ChangeShooterSpeed;
import frc.robot.commands.ChangeShooterSpeedChange;
import frc.robot.commands.ManualShoot;
import frc.robot.subsystems.Shooter;
import frc.robot.util.XboxController;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Shooter shooter = new Shooter();
  private final XboxController subsystemController = new XboxController(0);


  private final ManualShoot m_autoCommand = new ManualShoot(shooter);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Testing Shooter
    subsystemController.LB.whenPressed(new ChangeShooterSpeed(shooter, 1,false));
    subsystemController.LT.whenPressed(new ChangeShooterSpeed(shooter, 1,true));

    subsystemController.RB.whenPressed(new ChangeShooterSpeed(shooter, 2,false));
    subsystemController.RT.whenPressed(new ChangeShooterSpeed(shooter, 2,true));

    subsystemController.A.whenPressed(new ChangeShooterSpeedChange(shooter, (double)10));
    subsystemController.B.whenPressed(new ChangeShooterSpeedChange(shooter, (double)1/10));
    subsystemController.X.whenPressed(new ChangeShooterSpeedChange(shooter, (double)5));
    subsystemController.Y.whenPressed(new ChangeShooterSpeedChange(shooter, (double)1/5));

    subsystemController.rightStick.toggleWhenPressed(new ManualShoot(shooter));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public Shooter getShooter(){
    return shooter;
  }
}
