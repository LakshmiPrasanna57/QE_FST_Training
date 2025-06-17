package Practise;

import java.util.*;

public class Duplicate {
	public static void main(String[] args) {

        try {
            List<Integer> numbers = Arrays.asList(1,2,5,7,5,5); // Sample list with a duplicate
            checkForDuplicates(numbers);

            System.out.println("No duplicate numbers found.");

        } catch (DuplicateNumberException e) {

            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void checkForDuplicates(List<Integer> numbers) throws DuplicateNumberException {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
        	
            if (!uniqueNumbers.add(number)) {
                throw new DuplicateNumberException("Duplicate number found: " + number);
            }
        }
    }
}
