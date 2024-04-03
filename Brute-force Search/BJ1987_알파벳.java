import java.util.*;

public class BJ1987_알파벳 {
	
	static int n, m;
	static char[][] map;
	static int[][] dp;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	static Set<Character> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map = new char[n][m];
		dp = new int[n][m];
		
		for(int r = 0; r < n; r++) {
			map[r] = sc.nextLine().toCharArray();
		}
		
		set.add(map[0][0]);
		
		dfs(0, 0, 1);
		
		int ans = 1; 
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				ans = Math.max(ans, dp[r][c]);
			}
		}
		
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && !set.contains(map[nr][nc]) ) {
				set.add(map[nr][nc]);
				dp[nr][nc] = Math.max(cnt+1, dp[nr][nc]);
				dfs(nr, nc, cnt+1);
				set.remove(map[nr][nc]);
			}
		}
	}
}
