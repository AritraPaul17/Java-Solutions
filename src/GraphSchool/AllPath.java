package GraphSchool;

import java.util.ArrayList;

public class AllPath {

        private static void helper(ArrayList<Edge> graph[],int curr,int target,String s, boolean []vis){
            if(curr==target){
                System.out.println(s+curr);
                return;
            }
            vis[curr] = true;
            for(int i=0;i<graph[curr].size();i++){
                if(!vis[graph[curr].get(i).dest]){
                    int node = graph[curr].get(i).dest;
                    helper(graph,node,target,s+curr,vis);
                }
            }
            vis[curr] = false;
        }
        static void allPaths(ArrayList<Edge> graph[],int src,int target){
            System.out.println("calling allpaths");
            boolean []vis = new boolean[graph.length];
            helper(graph,src,target,"",vis);
        }
}
