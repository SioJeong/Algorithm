import java.util.*;

public class SWEA_등산로조성 {
	
	static int n, k, max, ans;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			
			max = Integer.MIN_VALUE;
			
			// 입력 
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
					max = map[r][c] > max ? map[r][c] : max;
				}
			}
			
			ans = Integer.MIN_VALUE;
			
			// 정상에서 등산로 찾기 시작
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					if(map[r][c] == max) {
						visited = new boolean[n][n];
						visited[r][c] = true;
						doDig(r, c, max, 1, false);
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	// 현재 좌표, 현재 높이, 등산로 길이, 공사 가능 유무를 인자로 하는 메서드 
	private static void doDig(int r, int c, int height, int cnt, boolean canDig) {
		// 현재 카운트를, 지금의 최댓값과 비교
		ans = Math.max(ans, cnt);
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 경계안에 있는, 방문한 적 없는 길
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
				// 높이가 낮다면
				if(map[nr][nc] < height) {
					visited[nr][nc] = true;
					// 재귀
					doDig(nr, nc, map[nr][nc], cnt+1, canDig);
					visited[nr][nc] = false;
				
				// 공사해서 지나갈 수 있고, 공사를 아직 안했다면
				} else if(map[nr][nc] - k < height && !canDig) {
					visited[nr][nc] = true;
					// 재귀로 들어가는데, 공사는 이제 불가능
					doDig(nr, nc, height-1, cnt+1, true);
					visited[nr][nc] = false;
				}
			}
		}
		
	}
}
