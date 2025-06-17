package Practise;

import java.util.Scanner;

public class Prac4_2 {
	    // Recursive method to get Fibonacci number at a given position
	    public static int fibonacci(int n) {
	        if (n <= 0) {
	            return 0; // Base case
	        } else if (n == 1) {
	            return 1; // Base case
	        } else {
	            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
	        }
	    }
	    // Main method
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input from user
	        System.out.print("Enter the position to get the Fibonacci number: ");
	        int position = scanner.nextInt();

	        if (position < 0) {
	            System.out.println("Position must be a non-negative integer.");
	        } else {
	            int result = fibonacci(position);
	            System.out.println("Fibonacci number at position " + position + " is: " + result);
	        }
	    }
	}
