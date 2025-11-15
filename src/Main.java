import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean solve(int[][] graph,boolean []safe,boolean []vis,int i){
        if(vis[i]){
            vis[i] = false;
            return false;
        }
        vis[i] = true;
        for(int x = 0;x<graph[i].length;x++){
            if(!safe[graph[i][x]]){
                boolean a = solve(graph,safe,vis,graph[i][x]);
                if(!a){
                    System.out.println(i + " " + graph[i][x]);
                    return false;
                }
            }
        }
        safe[i] = true;
        return true;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph){
        int n = graph.length;
        boolean[] safe = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0)
                safe[i] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                list.add(i);
            } else {
                boolean[] vis = new boolean[n];
                if (solve(graph, safe, vis, i)) {
                    list.add(i);
                }
            }

        }
        return list;
    }
    public static void main(String[] args) {
        int [][]graph ={{},{0,2,3,4},{3}, {4},{}};
        int n = graph.length;
        boolean[] safe = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0)
                safe[i] = true;
        }
        boolean[] vis = new boolean[n];
        ;
        System.out.println(solve(graph, safe, vis, 1));
    }
}