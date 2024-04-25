import java.util.*;

public class BJ1456_거의소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long[] arr = new long[10000001];
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}
		
		// 에라토스테네스의 체
		for(int i = 2; i <= Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			
			for(int j = i*2; j < 10000001; j += i) {
				arr[j] = 0;
			}
		}
		
		int cnt = 0;
		
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] != 0) {
				long pow = arr[i];
				
				while(pow <= b / arr[i]) {
					if(arr[i] * pow >= a) {
						cnt++;
					}
					pow *= arr[i];
				}
			}
		}
		
		System.out.println(cnt);
	}
}