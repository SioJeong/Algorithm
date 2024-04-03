import java.util.*;

public class SWEA_보호필름_2112 {
	
	static int n, m, stad;
	static int[] sel;
	static int[][] film, testFilm;
	static boolean finish;
	static Queue<int[]> comb; 
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			film = new int[n][m];
			stad = sc.nextInt();
			finish = false;
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {
					film[r][c] = sc.nextInt();
				}
			}
			
			int ans = stad;
			
			// 최대 k번까지 변경
			outer: for(int i = 0; i < stad; i++) {
				
				// 비트 마스킹
				for(int j = 1; j < (1 << n); j++) {
					list = new ArrayList<>();
					int cnt = 0;
					
					for(int k = 0; k < n; k++) {
						if((j & (1 << k)) > 0) {
							cnt++;
							list.add(k);
						}
						
						if(cnt == i) {
							test(cnt);
							
							if(finish) {
								ans = cnt;
								break outer;
							}
							
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void test(int cnt) {
		comb = new LinkedList<>();
		sel = new int[cnt];
		comb(0, cnt);
		
		testFilm = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			testFilm[i] = Arrays.copyOf(film[i], m);
		}
		
		while(!comb.isEmpty()) {
			int[] curr = comb.poll();
			
			int idx = 0;
			while(idx != cnt) {
				Arrays.fill(testFilm[list.get(idx)], curr[idx]);
				idx++;
			}
			
			if(finalTest()) {
				finish = true;
				return;
			}
		}
	}


	private static void comb(int sidx, int cnt) {
		if(sidx == cnt) {
			comb.add(Arrays.copyOf(sel, cnt));
			return;
		}
		
		for(int i = 0; i <= 1; i++) {
			sel[sidx] = i;
			comb(sidx + 1, cnt);
		}
	}
	
	
	
	private static boolean finalTest() {
		outer: for(int c = 0; c < m; c++) {
			int cnt = 1;
			
			for(int r = 1; r < n; r++) {
				if(testFilm[r][c] == testFilm[r-1][c]) {
					cnt++;
					
					if(cnt == stad) continue outer;
					
					} else {
						if(r > n-stad) return false;
						else cnt = 1;
				}
			}
		}
		return true;
	}
}