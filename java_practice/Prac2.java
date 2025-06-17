//Write the logic for a BinarySearch.

package Practise;

import java.util.Arrays;
import java.util.Scanner;

public class Prac2 {

    // Binary Search Method (Iterative)
	public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid; // Key found
            } else if (key > arr[mid]) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Key not found
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Input array
        System.out.print("Enter number of elements: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
       // Sort the array before binary search
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int key = s.nextInt();
        int index = binarySearch(arr, key);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
       s.close();
   }

}

