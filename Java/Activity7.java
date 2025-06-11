package Activites;

interface BicycleParts{
	int tyres= 2;
	int maxSpeed= 20;
}

interface BicycleOperations{
	void applyBrake(int decrementValue);
	void speedUp(int incrementValue);	
}

class Bicycle implements BicycleOperations, BicycleParts{
	int gears;
	int currentSpeed;
	
	Bicycle(int gears, int currentSpeed){
		this.gears =gears;
		this.currentSpeed= currentSpeed;
	}
	
	@Override
	public void applyBrake(int decrementValue) {
		System.out.println("cycle speed decresed");
		if(currentSpeed >= 0) {
			currentSpeed -= decrementValue;
		}
		else {
			System.out.println("Cycle Stopped");
		}
	}
	
	@Override
	public void speedUp(int incrementValue) {
		System.out.println("cycle speed incresed");
		if(currentSpeed <= maxSpeed) {
			currentSpeed += incrementValue;
		}
		else {
			System.out.println("Cycle at max speed");
		}
	}
	
	public void bicycleDesc() {
		System.out.println("Bicycle has" + gears + "gears," + tyres +"tyres and maxspeed of" +maxSpeed);
		System.out.println("its current speed is:" +currentSpeed);		
	}
}

class MountainBike extends Bicycle{
	int seatHeight;
	
	MountainBike(int gears, int currentSpeed, int seatHeight){
		super(gears, currentSpeed);
		this.seatHeight= seatHeight;		
	}
	public void setseatHeight(int newValue) {
		this.seatHeight = newValue;
	}
	
	@Override
	public void bicycleDesc() {
	System.out.println("MountainBike has" + gears + "gears," + tyres +"tyres and maxspeed of" +maxSpeed);
	System.out.println("current seat Height is:" +seatHeight);
	System.out.println("Current speed is:" +currentSpeed);		
	}
}
public class Activity7 {
	public static void main(String[] args) {
		Bicycle mb = new MountainBike(3,0, 25);
		mb.bicycleDesc();
		mb.speedUp(20);
		mb.applyBrake(5);
	}
}
