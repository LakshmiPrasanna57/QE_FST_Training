package Activites;

public class Activity3 {
	public static void main(String[] args) {
		
        // Age in seconds
        double seconds = 1000000000;

        // Earth year in seconds
        double earthSeconds = 31557600;

        // Orbital periods relative to Earth years
        double mercury = 0.2408467;
        double venus = 0.61519726;
        double mars = 1.8808158;
        double jupiter = 11.862615;
        double saturn = 29.447498;
        double uranus = 84.016846;
        double neptune = 164.79132;
        System.out.println("Age on  earth:" + seconds/ earthSeconds +" Years");
        System.out.println("Age on  mercury:" + seconds/ earthSeconds/ mercury +" Years");
        System.out.println("Age on  venus:" + seconds/ earthSeconds/ venus +" Years");
        System.out.println("Age on  mars:" + seconds/ earthSeconds/ mars +" Years");
        System.out.println("Age on  jupiter:" + seconds/ earthSeconds/ jupiter +" Years");
        System.out.println("Age on  saturn:" + seconds/ earthSeconds/ saturn +" Years");
        System.out.println("Age on  uranus:" + seconds/ earthSeconds/ uranus +" Years");
        System.out.println("Age on  neptune:" + seconds/ earthSeconds/ neptune +" Years");
        
}
}

        