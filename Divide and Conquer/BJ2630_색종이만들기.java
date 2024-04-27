import java.util.*;

public class BJ2630_색종이만들기 {
	
	static int n, blue, white;
	static int[][] paper;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		paper = new int[n][n];
		int sum = 0;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				paper[r][c] = sc.nextInt();
				
				if(paper[r][c] == 1) sum++;
			}
		}
		
		blue = 0;
		white = 0;
		
		if(sum == n*n) blue++;
		else if(sum == 0) white++;
		else split(0, n, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
		
	}

	private static void split(int startR, int endR, int startC, int endC) {
		if (!check(startR, endR, startC, endC)) {
	        int midR = (startR + endR) / 2;
	        int midC = (startC + endC) / 2;

	        split(startR, midR, startC, midC);
	        split(startR, midR, midC, endC);
	        split(midR, endR, startC, midC);
	        split(midR, endR, midC, endC);
		}
	}
	
	static boolean check(int startR, int endR, int startC, int endC) {
		int sum = 0;
		int cnt = 0;
		
		for(int r = startR; r < endR; r++) {
			for(int c = startC; c < endC; c++) {
				if(paper[r][c] == 1) sum++;
				cnt++;
			}
		}
		
		if(sum == cnt) {
			blue++;
			return true;
		} else if(sum == 0) {
			white++;
			return true;
		}
		
		return false;
	}
}
