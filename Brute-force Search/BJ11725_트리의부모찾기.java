import java.util.*;

public class BJ11725_트리의부모찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt(); 

		List<Integer>[] list = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < n-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}

		boolean[] visited = new boolean[n+1];
		int[] parents = new int[n+1]; 

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 0; i < list[curr].size(); i++) {
				if(!visited[list[curr].get(i)]) {
					queue.add(list[curr].get(i));
					visited[list[curr].get(i)] = true;
					parents[list[curr].get(i)] = curr;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}