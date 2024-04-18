import java.util.*;

public class BJ13023_ABCDE {
    static int n, m;
    static List<List<Integer>> adjList;
    static boolean flag;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        flag = false;
        
        for(int i = 0; i < n; i++) {
            dfs(i, 1, new boolean[n]);
            if(flag) break; // 이미 원하는 결과를 찾은 경우 종료
        }
        
        System.out.println(flag ? 1 : 0);
    }

    private static void dfs(int idx, int cnt, boolean[] visited) {
        if(flag || cnt == 5) {
            flag = true;
            return;
        }
        
        visited[idx] = true;
        
        for(int next : adjList.get(idx)) {
            if (!visited[next]) {
                dfs(next, cnt + 1, visited);
            }
        }
        
        visited[idx] = false;
    }
}
