//Factorial of the Number

package Practise;

import java.util.Scanner;

public class Prac4_1 {
	// Recursive method to calculate factorial
	    public static long factorial(int n) {
	        if (n == 0 || n == 1) {
	            return 1; // Base case
	        } else {
	            return n * factorial(n - 1); // Recursive case
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Input from user
	        System.out.print("Enter a number to find its factorial: ");
	        int number = sc.nextInt();

	        // Check for negative input
	        if (number < 0) {
	            System.out.println("Factorial is not defined for negative numbers.");
	        } else {
	            long result = factorial(number);
	            System.out.println("Factorial of " + number + " is: " + result);
	        }

	     }
	}


