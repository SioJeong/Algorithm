import java.util.*;

public class BJ11659_구간합구하기4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n+1];
		
		arr[1] = sc.nextInt();
		
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			System.out.println(arr[end] - arr[start-1]);
		}
			
	}
}
