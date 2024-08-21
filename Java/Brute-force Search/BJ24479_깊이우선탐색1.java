import java.util.*;

public class BJ24479_깊이우선탐색1 {
	
	static int n, m, cnt;
	static List<Integer>[] list;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();
		int start = sc.nextInt();
		
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}
		
		cnt = 1;
		dfs(start);
		
		for(int i = 1; i <= n; i++) {
			sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int idx) {
		visited[idx] = true;
		dist[idx] = cnt++;
		
		for(int i = 0; i < list[idx].size(); i++) {
			if(!visited[list[idx].get(i)]) {
				dfs(list[idx].get(i));
			}
		}
	}

}
