package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class ChangeShooterSpeedChange extends InstantCommand {

    private Shooter shooter;
    private double multiplier;

    public ChangeShooterSpeedChange(Shooter shooter, double multiplier) {
        this.shooter = shooter;
        this.multiplier = multiplier;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setSpeedChange(shooter.getSpeedChange() * multiplier);
        if (shooter.getSpeedChange() > 1) shooter.setSpeedChange(1);
        else if (shooter.getSpeedChange() == 0) shooter.setSpeedChange(1);
    }
}