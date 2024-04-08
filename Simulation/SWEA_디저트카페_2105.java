import java.util.*;

public class SWEA_디저트카페_2105 {
	
	static int n, ans;
	static int[][] city;
	static final int[] dr = {1, 1, -1, -1};
	static final int[] dc = {1, -1, -1, 1};
	static Set<Integer> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			city = new int[n][n];
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					city[r][c] = sc.nextInt();
				}
			}
			
			ans = -1;
			
			for(int r = 0; r < n-2; r++) {
				for(int c = 1; c < n-1; c++) {
					int startR = r;
					int startC = c;
					
					set = new HashSet<>();
					set.add(city[r][c]);
					
					dfs(r+dr[0], c+dc[0], startR, startC, 1, 0);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int r, int c, int startR, int startC, int cnt, int dir) {
		if(dir == 3 && r == startR && c == startC) {
			ans = Math.max(ans, cnt);
			return;
		}
		
		if(set.contains(city[r][c])) return;
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
			set.add(city[r][c]);
			dfs(nr, nc, startR, startC, cnt+1, dir);
			set.remove(city[r][c]);
		}
		
		dir = (dir+1) % 4;
		
		nr = r + dr[dir];
		nc = c + dc[dir];
		
		if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
			set.add(city[r][c]);
			dfs(nr, nc, startR, startC, cnt+1, dir);
			set.remove(city[r][c]);
		}
	}
	
}
