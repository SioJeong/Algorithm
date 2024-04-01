import java.util.*;

public class BJ2252_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer>[] list = new ArrayList[n+1];
		int[] indegree = new int[n+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			indegree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			if(indegree[i] == 0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr + " ");
			
			for(int i = 0; i < list[curr].size(); i++) {
				indegree[list[curr].get(i)]--;
					
				if(indegree[list[curr].get(i)] == 0) queue.add(list[curr].get(i));
			}
		}
		
		System.out.println(sb);
	}
}