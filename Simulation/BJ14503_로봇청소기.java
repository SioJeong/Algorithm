import java.util.*;

public class BJ14503_로봇청소기 {
    
    static int n, m;
    static int[][] map;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        
        int robotR = sc.nextInt();
        int robotC = sc.nextInt();
        int robotD = sc.nextInt();
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        
        robot(robotR, robotC, robotD);
        
        int cnt = 0;
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(map[r][c] == -1) cnt++;
            }
        }
        
        System.out.println(cnt);
        
    }

    private static void robot(int r, int c, int d) {
        if(map[r][c] == 0) {
            map[r][c] = -1;
        }
        
        for(int i = 0; i < 4; i++) {
        	int nd = (d + 3 - i) % 4;
        	int nr = r + dr[nd];
        	int nc = c + dc[nd];
        	
        	if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if(map[nr][nc] == 0) {
                    robot(nr, nc, nd); 
                    return;
                }
            }
        }
        
        int backD = (d + 2) % 4;
        int backR = r + dr[backD];
        int backC = c + dc[backD];
        
        if(backR >= 0 && backR < n && backC >= 0 && backC < m && map[backR][backC] != 1) {
            robot(backR, backC, d);
        }
    }
}