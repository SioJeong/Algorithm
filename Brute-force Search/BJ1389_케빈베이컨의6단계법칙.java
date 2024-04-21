import java.util.*;

public class BJ1389_케빈베이컨의6단계법칙 {
	
	static int n;
	static int[][] friends;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		friends = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			friends[a][b] = friends[b][a] = 1;
		}
		
		dist = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			dist[i] = dfs(i);
		}
		
		int min = Integer.MAX_VALUE;
		int ans = -1;
		
		for(int i = 1; i <= n; i++) {
			if(dist[i] < min) {
				min = dist[i];
				ans = i;
			}
		}
		
		System.out.println(ans);
		
	}

	private static int dfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> tmpQueue = new LinkedList<>();
		visited = new boolean[n+1];
		
		queue.add(idx);
		visited[idx] = true;
		
		int sum = 0;
		int cnt = 1;
		
		do {
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				
				
				for(int i = 1; i <= n; i++) {
					if(friends[curr][i] == 1 && !visited[i]) {
						tmpQueue.add(i);
						visited[i] = true;
						sum += cnt;
					}
				}
			}
			while(!tmpQueue.isEmpty()) {
				queue.add(tmpQueue.poll());
			}
			cnt++;
			
		} while(!visitAll());
		
		return sum;
	}

	private static boolean visitAll() {
		for(int i = 1; i <= n; i++) {
			if(visited[i] == false) return false;
		}
		
		return true;
	}
}
