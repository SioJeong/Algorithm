import java.util.*;
public class SWEA_홈방범서비스_2117 {
	
	static int n, m, max;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt(); // 도시의 크기
			m = sc.nextInt(); // 수익
			map = new int[n][n];
			
			// 도시 정보 
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			max = 0;
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					service(r, c);
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void service(int row, int col) {
		for(int k = 1; k <= 39; k++) {
			int cnt = 0;
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					if(Math.abs(r - row) + Math.abs(c - col) < k && map[r][c] == 1) cnt++;
				}
			}
			
			int cost = k * k + (k-1) * (k-1);
			int profit = cnt * m - cost;
			
			if(profit > 0) max = Math.max(max, cnt);
		}
		
	}
}
