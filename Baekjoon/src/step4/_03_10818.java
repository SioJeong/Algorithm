import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] numbers = new int[N];
		int max;
		int min;
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
			
		}
		max = numbers[0];
		min = numbers[0];
		
		for (int i = 0; i < N; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println(min + " " + max);
	}
}
