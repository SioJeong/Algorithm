import java.util.*;

public class SWEA_장훈이의높은선반_1486 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int b = sc.nextInt();
			int[] manager = new int[n];
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				manager[i] = sc.nextInt();
			}
			
			for(int i = 1; i < (1 << n); i++) {
				int sum = 0;
				for(int j = 0; j < n; j++) {
					if((i & (1 << j)) > 0) {
						sum += manager[j];
					}
				}
				
				if(sum >= b) {
					list.add(sum);
				}
			}
			
			Collections.sort(list);
			
			System.out.println("#" + tc + " " + (list.get(0) - b));
		}
	}
}
