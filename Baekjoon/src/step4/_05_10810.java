import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] baskets = new int[N];

		for (int i = 0; i < N; i++) {
			baskets[i] = 0;
		}

		for (int n = 0; n < M; n++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			for(int l = (i-1); l < j; l++) {
				baskets[l] = k;
				}
			}
		for(int i = 0; i < N; i++) {
			System.out.print(baskets[i]);
			if(i != (N-1)){
				System.out.print(" ");
			}
		}
	}
}
