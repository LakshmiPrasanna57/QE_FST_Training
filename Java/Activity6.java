package Activites;

import java.util.*;

class Plane{
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOff;
	private Date lastTimeLanded;
	
	public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList();
    }
	public void onBoard(String passengerName) {
        if (passengers.size() <= maxPassengers) {
            this.passengers.add(passengerName);
        } else {
            System.out.println("Plane is full");       
        }
    }
	
	public Date setTakeOff() {
        this.lastTimeTookOff = new Date();
        return lastTimeTookOff;
    }
	 public void setLand() {
	        this.lastTimeLanded = new Date();
	        this.passengers.clear();
	    }
	 
	 public Date getLastTimeLanded() {
	        return lastTimeLanded;
	    }
	    public List<String> getPassengers() {
	        return passengers; // Return copy to protect encapsulation
	    }
}

public class Activity6{
	public static void main(String[] args) throws InterruptedException{
		
		Plane plane = new Plane(10);
		
		plane.onBoard("Jhon");
		plane.onBoard("Steve");
		plane.onBoard("Anna");
		
		System.out.println("Plane took off:" + plane.setTakeOff());
		System.out.println("people on the plane:" + plane.getPassengers());
		
		Thread.sleep(5000);
		plane.setLand();
		System.out.println("Plane landed at:" + plane.getLastTimeLanded());
		System.out.println("people on the plane after landing:" +plane.getPassengers());
    }
}

