import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (sc.nextInt() % 42);
		}

		Arrays.sort(arr);
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				continue;
			} else if (arr[i] != arr[i + 1]) {
				count++;
			}
		}
		System.out.println(count+1);
	}
}