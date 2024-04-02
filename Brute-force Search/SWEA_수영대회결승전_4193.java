import java.util.*;

public class SWEA_수영대회결승전_4193 {
	
	static int n;
	static int[][] map, dist;
	static int[] start, goal;
	static boolean[][] visited;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) { // tc
		
			n = sc.nextInt();	
			map = new int[n][n];
			dist = new int[n][n];
			visited = new boolean[n][n];
			
			// 수영장 모양 입력 
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			// 출발 좌표 입력 
			start = new int[2];
			for(int i = 0; i < 2; i++) {
				start[i] = sc.nextInt();
			}
			
			// 도착 좌표 입력 
			goal = new int[2];
			for(int i = 0; i < 2; i++) {
				goal[i] = sc.nextInt();
			}
			
			dist[goal[0]][goal[1]] = Integer.MAX_VALUE;
			
			bfs(start[0], start[1]);
			
			int ans = -1;
			
			// 도착 가능하면 값 변경 
			if(dist[goal[0]][goal[1]] != Integer.MAX_VALUE) ans = dist[goal[0]][goal[1]];
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void bfs(int startR, int startC) {
		// 시작점 큐에 집어 넣기 
		Queue<int[]> queue = new LinkedList<>();
		dist[startR][startC] = 0;
		queue.add(new int[] {startR, startC});
		
		while(!queue.isEmpty()) {
			// 현재의 좌표 
			int[] curr = queue.poll();
			int currR = curr[0];
			int currC = curr[1];
			if(visited[currR][currC]) continue;
			
			for(int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];
				
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] != 1) {
					// 이동하려는 곳이 지나가지 않은 소용돌이
					// 2초를 기다려야할 때
					if(map[nr][nc] == 2 && (dist[currR][currC] % 3) == 0) {
						if(dist[nr][nc] != 0) {
							dist[nr][nc] = Math.min(dist[nr][nc], dist[currR][currC] + 3);
						}
						else dist[nr][nc] = dist[currR][currC] + 3;
						queue.add(new int[] {nr, nc});
					// 1초를 기다려야할 때
					} else if(map[nr][nc] == 2 && (dist[currR][currC] % 3) == 1) {
						if(dist[nr][nc] != 0) {
							dist[nr][nc] = Math.min(dist[nr][nc], dist[currR][currC] + 2);
						}
						else dist[nr][nc] = dist[currR][currC] + 2;
						queue.add(new int[] {nr, nc});
					// 소용돌이가 아니라면
					} else {
						if(dist[nr][nc] != 0) {
							dist[nr][nc] = Math.min(dist[nr][nc], dist[currR][currC] + 1);
						}
						else dist[nr][nc] = dist[currR][currC] + 1;
						queue.add(new int[] {nr, nc});
					}
				}
			}
			visited[currR][currC] = true;
		}
	}
}
