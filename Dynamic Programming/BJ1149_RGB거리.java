import java.util.*;

public class BJ1149_RGB거리 {
    
    static int n;
    static int[][] painting;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        painting = new int[n][3];
        
        for(int i = 0; i < n; i++) {
            painting[i][0] = sc.nextInt();
            painting[i][1] = sc.nextInt();
            painting[i][2] = sc.nextInt();
        }
        
        int minCost = findMinCost();
        
        System.out.println(minCost);
    }

    private static int findMinCost() {
        int[][] dp = new int[n][3];
        
        dp[0][0] = painting[0][0];
        dp[0][1] = painting[0][1];
        dp[0][2] = painting[0][2];
        
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + painting[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + painting[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + painting[i][2];
        }
        
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}
