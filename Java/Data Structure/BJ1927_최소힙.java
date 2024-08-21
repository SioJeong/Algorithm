import java.util.*;

public class BJ1927_최소힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int input = sc.nextInt();
			
			if(input == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll() + "\n");
			} else {
				pq.add(input);
			}
		}
		
		System.out.println(sb);
	}
}