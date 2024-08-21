import java.util.*;
 
public class SWEA_작업순서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int tc = 1; tc <= 10; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            int v = sc.nextInt();
            int e = sc.nextInt();
            int[][] adj = new int[v+1][v+1];
            int[] indegree = new int[v+1];
             
            for(int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                 
                adj[a][b] = 1;
                indegree[b]++;
            }
             
//          System.out.println(Arrays.toString(indegree));
             
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= v; i++) {
                if(indegree[i] == 0) queue.add(i);
            }
             
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                sb.append(curr + " ");
                 
                for(int i = 1; i <= v; i++) {
                    if(adj[curr][i] == 1) {
                        indegree[i]--;
                         
                        if(indegree[i] == 0) {
                            queue.add(i);
                        }
                    }
                }
            }
             
            System.out.println(sb);
        }
    }
}