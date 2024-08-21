import java.util.*;

public class SWEA_벽돌깨기_5656 {
	
	static int n, w, h, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			int[][] map = new int[h][w];
			
			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			ans = Integer.MAX_VALUE;
			game(0, map);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void game(int stage, int[][] map) {
		// basecase 
		if(stage == n) {
			int sum = 0;
			
			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					if(map[r][c] > 0) sum++;
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = 0; i < w; i++) {
			int[][] nowStageMap = new int[h][w];
			
			for(int r = 0; r < h; r++) {
				nowStageMap[r] = Arrays.copyOf(map[r], w);
			}
			
			nowStageMap = breakBlock(i, nowStageMap);
			game(stage+1, nowStageMap);
		}
	}

	// bfs로 벽돌 깨기 
	private static int[][] breakBlock(int i, int[][] nowStageMap) {
		Queue<int[]> queue = new LinkedList<>();
		
		// 처음 벽돌 queue에 넣기 
		for(int r = 0; r < h; r++) {
			if(nowStageMap[r][i] > 0) {
				queue.add(new int[] {r, i, nowStageMap[r][i]});
				break;
			}
		}
		
		while (!queue.isEmpty()) {
	        int[] curr = queue.poll();
	        int currR = curr[0];
	        int currC = curr[1];
	        int currValue = curr[2];

	        // 현재 벽돌 폭발
	        nowStageMap[currR][currC] = 0;

	        // 폭발 범위 내 모든 벽돌 (값 1 포함)을 큐에 추가하여 재귀적으로 폭발 진행
	        for (int t = 1; t <= currValue - 1; t++) {
	            int[] dr = {-t, 0, t, 0};
	            int[] dc = {0, t, 0, -t};
	            
	            for (int d = 0; d < 4; d++) {
	                int nr = currR + dr[d];
	                int nc = currC + dc[d];
	                
	                if (nr >= 0 && nr < h && nc >= 0 && nc < w && nowStageMap[nr][nc] > 0) {
	                    queue.add(new int[] {nr, nc, nowStageMap[nr][nc]}); // 모든 범위 벽돌 추가
	                }
	            }
	        }
	    }
	    return sort(nowStageMap);
	}

	private static int[][] sort(int[][] nowStageMap) {
		for(int c = 0; c < w; c++) {
			int start = h-1;
			while(start >= 0) {
				if(nowStageMap[start][c] == 0) { // 빈 공간인 경우
                    int temp = start - 1;
                    while(temp >= 0 && nowStageMap[temp][c] == 0) temp--; // 빈 공간이 아닌 값 찾기
                    if(temp >= 0) {
                        nowStageMap[start][c] = nowStageMap[temp][c]; // 값 복사
                        nowStageMap[temp][c] = 0; // 원래 위치 초기화
                    }
                }
                start--; // 다음 줄 탐색
			}
		}
		
		return nowStageMap;
	}
}
