import java.util.*;

public class BJ11724_연결요소의개수 {
	
	static int n;
	static int[][] nodes;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		nodes = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			nodes[a][b] = nodes[b][a] = 1;
		}
		
		visited = new boolean[n+1];
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			
			dfs(i);
			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}

	private static void dfs(int idx) {
		visited[idx] = true;
		
		for(int i = 1; i <= n; i++) {
			if(nodes[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
