import java.util.*;

public class SWEA_벌꿀채취 {

    static int n, m, c, honeyMax, profitMax;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt(); // 한 번에 채취 가능한 꿀통 수 
            honeyMax = sc.nextInt(); // 한 번에 채취 가능한 최대 꿀 양 
            map = new int[n][n];
            visited = new boolean[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
            
            int ans = 0;
            profitMax = 0;
            
            // 꿀벌맨 1 
            for(int r = 0; r < n; r++) {
            	for(int c = 0; c <= n-m; c++) {
            		check(r, c, 0);
            	}
            }
            
            ans += profitMax;
            profitMax = 0;
            
            // 꿀벌맨 2 
            for(int r = 0; r < n; r++) {
            	for(int c = 0; c <= n-m; c++) {
            		int cnt = 0;
            		
            		// 지금 지점에서 m칸까지 이미 꿀벌맨 1이 채취한 구역이면 패스 
            		for(int i = 0; i < m; i++) {
            			if(visited[r][c+i]) cnt++;;
            		}
            		
            		if(cnt == 0) check(r, c, 1);
            	}
            }
            
            ans += profitMax;
            
            System.out.println("#" + tc + " " + ans);

        }
    }
    
    
	private static void check(int row, int col, int stage) {
		for(int i = 1; i < (1 << m); i++) {
			String binary = Integer.toBinaryString(i); // 꿀통 조합을 이진수 문자열로 변경 
			
			while (binary.length() < m) binary = "0" + binary; // 문자열의 길이가 m보다 짧다면 앞에 0문자 추가 
			
			int honey = 0;
			int profit = 0;
			
			for(int j = 0; j < m; j++) {
				if(binary.charAt(j) == '1') { // 문자열에 1 들어가는 꿀통만 계산 
					honey += map[row][col+j];
					profit += map[row][col+j] * map[row][col+j];
				}
			}
			
			if(honey <= honeyMax && profit >= profitMax) {
				profitMax = profit;
				
				// 꿀벌맨 1만 방문처리 하기 
				if(stage == 0) {
					for(boolean[] arr : visited) {
						Arrays.fill(arr, false);
					}
					
					for(int k = 0; k < m; k++) {
						visited[row][col+k] = true;
					}
				}
			}
		}
	}
}
