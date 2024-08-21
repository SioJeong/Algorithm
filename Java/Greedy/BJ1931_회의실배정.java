import java.util.*;

public class BJ1931_회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long[][] arr = new long[n][2];
        
        for(int i = 0; i < n; i++) {
            arr[i] = new long[] {sc.nextLong(), sc.nextLong()};
        }
        
        Arrays.sort(arr, new Comparator<long[]>() {

            @Override
            public int compare(long[] l1, long[] l2) {
            	if(l1[1] == l2[1]) return Long.compare(l1[0], l2[0]);
                return Long.compare(l1[1], l2[1]);
            }
        });
        
        int cnt = 0;
        long prevEnd = 0;
        
        for(int i = 0; i < n; i++) {
        	if(arr[i][0] >= prevEnd) {
        		prevEnd = arr[i][1];
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
}
