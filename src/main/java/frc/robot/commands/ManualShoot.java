package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;
import frc.robot.util.XboxController;

public class ManualShoot extends CommandBase {

    private Shooter shooter;
    private XboxController controller;
    private double topSpeed, bottomSpeed;

    public ManualShoot(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setMotors(shooter.getTopSpeed(), shooter.getBottomSpeed());
    }

    @Override
    public void end(boolean interrupted) {
        
        shooter.setMotors(0, 0);
    }
}