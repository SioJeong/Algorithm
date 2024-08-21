import java.util.*;

public class BJ11660_구간합구하기5 {
	
	static int n, m;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1][n+1];
		
		for(int r = 1; r <= n; r++) {
			arr[r][1] = sc.nextInt();
			
			for(int c = 2; c <= n; c++) {
				arr[r][c] = arr[r][c-1] + sc.nextInt();
			}
		}
		
		for(int i = 0; i < m; i++) {
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			int endR = sc.nextInt();
			int endC = sc.nextInt();
			
			int sum = 0;
			
			for(int r = startR; r <= endR; r++) {
				sum += arr[r][endC] - arr[r][startC-1];
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}
}
