import java.util.*;

public class SWEA_오셀로게임_4615 {
	
	static int n;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			map[n/2-1][n/2-1] = 2;
			map[n/2][n/2] = 2;
			map[n/2-1][n/2] = 1;
			map[n/2][n/2-1] = 1;
			int m = sc.nextInt();
			
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int color = sc.nextInt();
				
				turn(b, a, color);
				
//				for(int[] arr : map) {
//					System.out.println(Arrays.toString(arr));
//				}
//				System.out.println("-------------------------------------");
			}
			
			int bCnt = 0;
			int wCnt = 0;
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					if(map[r][c] == 1) bCnt++;
					if(map[r][c] == 2) wCnt++;
				}
			}
			
			System.out.println("#" + tc + " " + bCnt  + " " + wCnt);
			
		}
	}

	private static void turn(int r, int c, int color) {
		map[r][c] = color;
		
		loop: for(int d = 0; d < 8; d++) {
			Queue<int[]> queue = new LinkedList<>();
			int i = 1;
			
			while(true) {
				int[] dr = {-i, -i, 0, i, i, i, 0, -i};
				int[] dc = {0, i, i, i, 0, -i, -i, -i};
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue loop;
				
				if(color == 1) {
					if(map[nr][nc] == 2) {
						queue.add(new int[] {nr, nc});
						i++;
						continue;
					}
					
					if(map[nr][nc] == 0) continue loop;
					if(map[nr][nc] == 1 && queue.isEmpty()) continue loop;
					
					if(map[nr][nc] == 1 && !queue.isEmpty()) {
						
						while(!queue.isEmpty()) {
							int[] curr = queue.poll();
							int currR = curr[0];
							int currC = curr[1];
							
							map[currR][currC] = 1;
						}
						continue loop;
					}
					
				} else if(color == 2) {
					if(map[nr][nc] == 1) {
						queue.add(new int[] {nr, nc});
						i++;
						continue;
					}
					
					if(map[nr][nc] == 0) continue loop;
					if(map[nr][nc] == 2 && queue.isEmpty()) continue loop;
					
					if(map[nr][nc] == 2 && !queue.isEmpty()) {
						
						while(!queue.isEmpty()) {
							int[] curr = queue.poll();
							int currR = curr[0];
							int currC = curr[1];
							
							map[currR][currC] = 2;
						}
						continue loop;
					}
				}
			}
		}
	}
}