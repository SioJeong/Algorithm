import java.util.*;

public class BJ11047_동전0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		
		for(int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}
		
		int ans = 0;
		
		for(int i = n-1; i >= 0; i--) {
			if(k / coin[i] > 0) {
				ans += k / coin[i];
				k %= coin[i];
				
				if(k == 0) break;
			}
		}
		
		System.out.println(ans);
	}
}
