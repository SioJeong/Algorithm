import java.util.*;

public class BJ2579_계단오르기 {
	
	static int[] points, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		points = new int[n+1];
		dp = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			points[i] = sc.nextInt();
		}
		
		dp[1] = points[1];
		
		if(n > 1) dp[2] = points[1] + points[2];
		
		System.out.println(find(n));
	}

	private static int find(int idx) {
		if(idx <= 2) return dp[idx];
		
		if(dp[idx] == 0) {
			dp[idx] = Math.max(find(idx-2), find(idx-3) + points[idx-1]) + points[idx];
		}
		
		return dp[idx];
	}
}
