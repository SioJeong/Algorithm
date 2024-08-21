import java.util.Scanner;

public class BJ1850_최대공약수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		
		while(min > 0) {
			long tmp = max;
			max = min;
			min = tmp % min;
		}
		
		for(int i = 0; i < max; i++) {
			sb.append(1);
		}
		
		System.out.println(sb);
	}
}
