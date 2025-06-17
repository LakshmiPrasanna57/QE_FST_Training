/*Compare three numbers - x, y, and z. Print whether all are equal, 
two are equal, or all are not equal.*/

package Practise;

import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();
		 
		if(num1 == num2 && num2 == num3 ) {
			System.out.println("All are Equal");
		} else	if( num1 == num2 || num2 == num3 || num1 == num3 ){
			System.out.println("Two are  Equal");			
		}
		else {
			System.out.println("All are not Equal");
		}
	}

}
