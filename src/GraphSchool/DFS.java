package GraphSchool;

import java.util.ArrayList;

public class DFS {

    private void helper(ArrayList<Edge> graph[],int curr,boolean []vis){
        if(!vis[curr]){
            System.out.print(curr+" ");
            vis[curr] = true;
            for(int i=0;i<graph[curr].size();i++){
                helper(graph,graph[curr].get(i).dest,vis);
            }
        }
    }
    public void dfs(ArrayList<Edge> graph[],int curr){
        System.out.println("calling DFS");
        boolean []vis = new boolean[graph.length];
        helper(graph,curr,vis);
    }
}
