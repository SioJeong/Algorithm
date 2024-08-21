import java.util.*;

public class BJ10026_적록색약 {

	static int n;
	static char[][] field;
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		field = new char[n][n];

		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();

			field[i] = input.toCharArray();
		}
		
		int ans1 = bfs();
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(field[r][c] == 'R') field[r][c] = 'G';
			}
		}
		
		int ans2 = bfs();
		
		System.out.println(ans1 + " " + ans2);
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int cnt = 0;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(visited[r][c]) continue;
				
				queue.add(new int[] {r, c});
				visited[r][c] = true;
				cnt++;
				
				while(!queue.isEmpty()) {
					int[] curr = queue.poll();
					int currR = curr[0];
					int currC = curr[1];
					
					for(int d = 0; d < 4; d++) {
						int nr = currR + dr[d];
						int nc = currC + dc[d];
						
						if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && field[nr][nc] == field[currR][currC]) {
							queue.add(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		return cnt;
	}
}
