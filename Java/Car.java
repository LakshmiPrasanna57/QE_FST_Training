package Activites;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres; 
	int doors;

	Car(String color, String transmission, int make){
		this.color= color;
		this.transmission= transmission;
		this.make=make;
		this.tyres=4;
		this.doors=4;
	}
	void displayCharacteristics() {
		System.out.println("color of the car is: " +this.color);
		System.out.println("Transmission type is :" +this.transmission);
		System.out.println("car was made in:" +this.make);
		System.out.println("It has" +this.tyres + "tyres and" +this.doors +"doors");		
	}
	void accelerate() {
		System.out.println("The car moves forward.");
	}
	void brake() {
		System.out.println("The car has stopped");
	}
}
