package Activites;

public class Activity4 {
	public static void insertion(int[] array) {
		for (int i = 1; i < array.length; i++) {
            int key = array[i];           // Current element to be inserted
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];  // Shift element to the right
                j = j - 1;
            }
            array[j + 1] = key;     
		}
		
	}
	public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] numbers = {7,5,3,2,9,8};

        System.out.println("Before sorting:");
        printArray(numbers);

        insertion(numbers);
        System.out.println("After sorting:");
        printArray(numbers);
    }
}


