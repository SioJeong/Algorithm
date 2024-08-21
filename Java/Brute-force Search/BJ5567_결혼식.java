import java.util.*;

public class BJ5567_결혼식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer>[] list = new ArrayList[n+1];
		
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		if(list[1].size() == 0) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		visited[1] = true;
		int cnt = 0;
		
		for(int i = 0; i < list[1].size(); i++) {
			queue.add(list[1].get(i));
			visited[list[1].get(i)] = true;
			cnt++;
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 0; i < list[curr].size(); i++) {
				if(!visited[list[curr].get(i)]) {
					visited[list[curr].get(i)] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
