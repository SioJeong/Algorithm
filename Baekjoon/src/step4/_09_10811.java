import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = (i + 1);
		}
		
		int I;
		int J;
		
		for(int i = 0; i < M; i++) {
			I = sc.nextInt() - 1;
			J = sc.nextInt() - 1;
			
			while(I < J) {
				
				int temp = arr[I];
				arr[I] = arr[J];
				arr[J] = temp;
				
				I++;
				J--;
					
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i]);
			if(i != (N-1)) {
				System.out.print(" ");
			}
		}
	}
}