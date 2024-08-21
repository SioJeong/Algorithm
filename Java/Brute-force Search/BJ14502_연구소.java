import java.util.*;

public class BJ14502_연구소 {
	
	static int n, m;
	static int[][] map, sel, copyMap;
	static List<int[]> constructable = new ArrayList<>();
	static Queue<int[][]> comb = new LinkedList<>();
	static boolean[] selected;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				int input = sc.nextInt();
				map[r][c] = input;
				
				if(input == 0) constructable.add(new int[] {r, c});
			}
		}
		
		sel = new int[3][2];
		selected = new boolean[constructable.size()];
		
		comb(0, 0);
		
		int max = 0;
		
		while(!comb.isEmpty()) {
			copyMap = new int[n][m];
			
			for(int j = 0; j < n; j++) {
				copyMap[j] = Arrays.copyOf(map[j], m);
			}
			
			int[][] wall = comb.poll();
			
			for(int j = 0; j < 3; j++) {
				copyMap[wall[j][0]][wall[j][1]] = 1;
			}
			
			virus();
			
			int cnt = 0;
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {
					if(copyMap[r][c] == 0) {
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	private static void virus() {
		Queue<int[]> infection = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(copyMap[r][c] == 2) {
					infection.add(new int[] {r, c});
				}
			}
		}
		
		while(!infection.isEmpty()) {
			int[] curr = infection.poll();
			int currR = curr[0];
			int currC = curr[1];
			
			visited[currR][currC] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					visited[nr][nc] = true;
					infection.add(new int[] {nr, nc});
				}
			}
		}
	}

	private static void comb(int cnt, int idx) {
		if(cnt == 3) {
			comb.add(Arrays.copyOf(sel, sel.length));
			return;
		}
		
		for(int i = idx; i < constructable.size(); i++) {
			if(!selected[i]) {
				sel[cnt] = constructable.get(i);
				selected[i] = true;
				comb(cnt + 1, i + 1);
				selected[i] = false;
			}
		}
	}
}
