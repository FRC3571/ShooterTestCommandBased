package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private static final int kTopMotorID = 21;
    private static final int kBottomMotorID = 11;

    private CANSparkMax topMotor;
    private CANSparkMax bottomMotor;

    private CANEncoder topEncoder;
    private CANEncoder bottomEncoder;

    private double topSpeed, bottomSpeed;

    private double speedChange;

    public Shooter() {
        topMotor = new CANSparkMax(kTopMotorID, MotorType.kBrushless);
        bottomMotor = new CANSparkMax(kBottomMotorID, MotorType.kBrushless);

        topMotor.restoreFactoryDefaults();
        bottomMotor.restoreFactoryDefaults();

        topMotor.setInverted(false);
        bottomMotor.setInverted(false);

        speedChange = 0.01;

        initEncoders();
    }

    public void log() {
        SmartDashboard.putNumber("Shooter/TopMotor/Speed", topSpeed);
        SmartDashboard.putNumber("Shooter/BottomMotor/Speed", bottomSpeed);
        SmartDashboard.putNumber("Shooter/BottomMotor/SpeedChange", speedChange);
    }

    public void setMotors(double topSpeed, double bottomSpeed) {
        topMotor.set(topSpeed);
        bottomMotor.set(bottomSpeed);
    }

    private void initEncoders() {
        topEncoder = topMotor.getEncoder();
        bottomEncoder = bottomMotor.getEncoder();
    }

    public double getBottomSpeed() {
		return bottomSpeed;
	}

	public void setBottomSpeed(double bottomSpeed) {
		this.bottomSpeed = bottomSpeed;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
    }
    
    public double getSpeedChange(){
        return speedChange;
    }

    public void setSpeedChange(double speedChange){
        this.speedChange = speedChange;
    }
}
