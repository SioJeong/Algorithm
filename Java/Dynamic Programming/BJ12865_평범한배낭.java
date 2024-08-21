import java.util.*;

public class BJ12865_평범한배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		int[][] dp = new int[n+1][k+1];
		
		for(int i = 1; i <= n; i++) {
			for(int w = 1; w <= k; w++) {
				if(weight[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - weight[i]] + value[i]);
					
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
