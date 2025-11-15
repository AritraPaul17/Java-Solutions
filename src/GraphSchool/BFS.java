package GraphSchool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static public void bfs(ArrayList<Edge> graph[]){
        System.out.println("calling BFS");
        Queue<Integer> q = new LinkedList<>();
        boolean []vis = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int a = q.remove();
            if(!vis[a]){
                System.out.print(a+" ");
                vis[a] = true;
                for(int i=0;i<graph[a].size();i++){
                    q.add(graph[a].get(i).dest);
                }
            }
        }
    }
}
