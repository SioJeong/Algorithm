import java.util.*;

public class BJ11279_최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((Integer n1, Integer n2) -> {
			return n2-n1;
		});
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