//autonomous drive class
import edu.wpi.first.wpilibj.PIDController;

public class AutoDrive {
	MecanumDrive drive;
	PIDController pid;
	LIDAR lidar;
	public AutoDrive(MecanumDrive d, PIDController p, LIDAR l){
		drive = d;
		pid = p;
		lidar = l;
	}
	
	public void pidDrive(double distance, double minIn, double maxIn){
		pid.setInputRange(minIn, maxIn);
		pid.setSetpoint(distance);
		lidar.start();
		pid.enable();
		while(1==1){
			if((pid.get() <= .05 && pid.get() >= 0) || (pid.get() >= -.05 && pid.get() <= 0)){
				pid.disable();
				break;
			}
		}
		lidar.stop();
	}
	
	//drives forward at quarter speed
	public void forwardDrive(){
		drive.setSpeed(0);
		drive.drive(0, -1, 0);
	}
	
	//drives backward at quarter speed
	public void backwardDrive(){
		drive.setSpeed(0);
		drive.drive(0, 1, 0);
	}
	
	//drives left at quarter speed
	public void leftDrive(){
		drive.setSpeed(0);
		drive.drive(-1, 0, 0);
	}
	
	//drives right at quarter speed
	public void rightDrive(){
		drive.setSpeed(0);
		drive.drive(1, 0, 0);
	}
	
	//turns left at quarter speed
	public void leftTurn(){
		drive.setSpeed(0);
		drive.drive(0,0,-1);
	}
	
	//turns right at quarter speed
	public void rightTurn(){
		drive.setSpeed(0);
		drive.drive(0,0,1);
	}
}
