package Activites;

public class Activity2 {
	public static void main(String[] args) {
		int[] num = {1,10,7,9,10,5,10};
		System.out.println("Is the sum of 10s equal to 30 " + countTens(num));
	}
		public static boolean countTens(int[] num) {
			int sum=0;
			for(int number: num) {
				if(number==10) {
					sum+= number;
					System.out.println(sum);
			}
				if(sum>30) {
					break;
				}
		}
			return sum==30;
	}
}
