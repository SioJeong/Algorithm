import java.util.*;

public class BJ1747_소수_팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[2000000];
		
		for(int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			
			for(int j = i*2; j < arr.length; j += i) {
				arr[j] = 0;
			}
		}
		
		for(int i = n; i < arr.length; i++) {
			if(arr[i] != 0 && isPalindrome(i)) {
				System.out.println(i);
				return;
			}
		}
		
		
	}

	private static boolean isPalindrome(int n) {
		String num = String.valueOf(n);
		
		for(int i = 0; i < num.length() / 2; i++) {
			if(num.charAt(i) != num.charAt(num.length()-i-1)) return false;
		}
		
		return true;
	}
}
