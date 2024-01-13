import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N = 3
		double[] arr = new double[N]; // arr.length = 3
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); // 점수 입
		}
		
		double M = 0; // 최고 점수 초기화
		
		for(int i = 0; i < N; i++) {
			if(arr[i] > M) {
				M = arr[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / M * 100;
		}
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
		}
		System.out.println(sum / N);
	}
}