import java.util.*;

public class BJ11286_절댓값힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<> ((n1, n2) -> {
			int abs1 = Math.abs(n1);
			int abs2 = Math.abs(n2);
			
			if(abs1 == abs2) return n1 > n2 ? 1 : -1;
			return abs1 - abs2;
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int input = sc.nextInt();
			
			if(input == 0) {
				if(pq.isEmpty()) sb.append('0' + "\n");
				else sb.append(pq.poll() + "\n");
				
			} else {
				pq.add(input);
			}
		}
		
		System.out.println(sb);
	}
}