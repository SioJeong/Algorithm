import java.util.*;

public class SWEA_프로세서연결하기 {
	
	static int n, maxCore, minDist;
	static int[][] processor;
	static List<int[]> cores;
	static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			processor = new int[n][n];
			cores = new ArrayList<>();
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					processor[r][c] = sc.nextInt();
					
					// 프로세서의 바깥쪽에 있는 코어는 연결 리스트 제외
					if(processor[r][c] == 1 && r != 0 && c != 0 && r != n-1 && c != n-1) {
						cores.add(new int[] {r, c}); 
					}
				}
			}
			
			maxCore = 0;
			minDist = Integer.MAX_VALUE;
			
			connection(0, 0, 0);
			
			System.out.println("#" + tc + " " + minDist);
		}
	}
	

	private static void connection(int idx, int core, int totalDist) {
		// 모든 코어를 확인 했을 때
        // 코어가 가장 많으면서 가장 짧은 거리 비교
		if(idx == cores.size()) {
			if(core > maxCore) {
				maxCore = core;
				minDist = totalDist;
			}
			else if(core == maxCore) {
				minDist = Math.min(minDist, totalDist);
			}
			return;
		}
		
		int[] currCore = cores.get(idx);
		int r = currCore[0];
		int c = currCore[1];
		
		for(int d = 0; d < 4; d++) {
			int dist = checkThisWay(r, c ,d);
			
			if(dist > 0) {
				connectThisWay(r, c, d, 1);
				connection(idx + 1, core + 1, totalDist + dist);
				connectThisWay(r, c, d, 0);
			}
		}
		
		// 해당 코어를 건너뛰는 경우
        connection(idx + 1, core, totalDist);
	}

	// d방향으로 연결 및 연결 해제
	private static void connectThisWay(int r, int c, int d, int value) {
	    int nr = r;
	    int nc = c;
	    
	    while(true) {
	    	nr += dr[d];
	    	nc += dc[d];
	    	
	    	// 범위를 벗어나면 종료
	    	if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
	    	
	    	processor[nr][nc] = value;
	    }
	}

	// 이 방향으로 연결 가능한지 체크 
	// 가능하다면 거리 얼마인지 확인 
	private static int checkThisWay(int r, int c, int d) {
	    int distance = 0;
	    
	    int nr = r;
	    int nc = c;
	    
	    while(true) {
	    	nr += dr[d];
	    	nc += dc[d];
	    	
	    	// 범위를 벗어나면 종료
	    	if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
	    	
	    	// 이 방향에 프로세서 있다면 불가능 
	    	if(processor[nr][nc] == 1) return 0;
	    	distance++;
	    }
	    
		return distance;
	}

}
