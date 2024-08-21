import java.util.*;

public class BJ17144_미세먼지안녕 {
	
	static int n, m, t, cleanerR, cleanerC;
	static int[][] map;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		map = new int[n][m];
		
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				map[r][c] = sc.nextInt();
				
				if(map[r][c] == -1) {
					cleanerR = r;
				}
			}
		}
		
		for(int i = 0; i < t; i++) {
			diffusion();
			purification();
			
//			for(int[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
		}
		int ans = 0;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				ans += map[r][c];
			}
		}
		
		System.out.println(ans + 2);
		
	}

	private static void diffusion() {
		int[][] copyMap = new int[n][m];
		for(int r = 0; r < n; r++) {
			copyMap[r] = Arrays.copyOf(map[r], m);
		}
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				
				if(copyMap[r][c] != -1 && copyMap[r][c] != 0) {
					int tmp = copyMap[r][c] / 5;
					
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr >= 0 && nr < n && nc >= 0 && nc < m && copyMap[nr][nc] != -1) {
							map[nr][nc] += tmp;
							map[r][c] -= tmp;
						}
					}
				}
			}
		}
	}

	private static void purification() {
		for(int r = cleanerR-2; r > 0; r--) {
			map[r][0] = map[r-1][0];
		}
		
		for(int c = 1; c < m; c++) {
			map[0][c-1] = map[0][c];
		}
		
		for(int r = 1; r <= cleanerR-1; r++) {
			map[r-1][m-1] = map[r][m-1];
		}
		
		for(int c = m-1; c > 1; c--) {
			map[cleanerR-1][c] = map[cleanerR-1][c-1];
		}
		
		for(int r = cleanerR+1; r < n-1; r++) {
			map[r][0] = map[r+1][0];
		}
		
		for(int c = 0; c < m-1; c++) {
			map[n-1][c] = map[n-1][c+1];
		}
		
		for(int r = n-1; r > cleanerR; r--) {
			map[r][m-1] = map[r-1][m-1];
		}
		
		for(int c = m-1; c > 1; c--) {
			map[cleanerR][c] = map[cleanerR][c-1];
		}
		
		map[cleanerR-1][1] = 0;
		map[cleanerR][1] = 0;
	}
}
