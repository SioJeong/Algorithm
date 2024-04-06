import java.util.*;

public class BJ17471_게리멘더링 {
	
	static int n;
	static int[] popu;
	static int[][] city;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		popu = new int[n+1];
		city = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			popu[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= n; i++) {
			int t = sc.nextInt();
			for(int j = 0; j < t; j++) {
				city[i][sc.nextInt()] = 1;
			}
		}

		int min = -1;
		
		for(int i = 1; i < (1 << n) -1; i++) {
			List<Integer> areaA = new ArrayList<>();
			List<Integer> areaB = new ArrayList<>();
			
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) > 0) {
					areaA.add(j+1);
				} else {
					areaB.add(j+1);
				}
			}
			
			if(check(areaA) && check(areaB)) {
				if(min == -1) {
					min = calc(areaA, areaB);
					
				} else {
					min = Math.min(min, calc(areaA, areaB));
				}
				
				if(min == 0) {
					System.out.println(min);
					return;
				}
				
			}
		}
		
		System.out.println(min);
	}

	
	private static int calc(List<Integer> areaA, List<Integer> areaB) {
		
		int sumA = 0;
		int sumB = 0;
		
		for(int i = 0; i < areaA.size(); i++) {
			sumA += popu[areaA.get(i)];
		}
		
		for(int i = 0; i < areaB.size(); i++) {
			sumB += popu[areaB.get(i)];
		}
		
		return Math.abs(sumA - sumB);
		
	}

	private static boolean check(List<Integer> area) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(area.get(0));
        visited[area.get(0)] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i : area) {
                if (city[curr][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for (int i : area) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
