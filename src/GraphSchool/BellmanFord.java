package GraphSchool;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    static void bellmanFord(ArrayList<Edge> graph[], int src, int dest){
//        Time Complexity - O(V * E)
        System.out.println("Calling Bellman Ford algorithm ...");

        int v = graph.length;
        int[] dis = new int[v];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

        for(int i=0;i<v-1;i++){ //O(V)

            // O(E)
            for(int j=0;j<v;j++){
                for(int k=0;k<graph[j].size();k++){
                    int destiny = graph[j].get(k).dest;
                    int distance = graph[j].get(k).dist;
                    if(dis[j]!=Integer.MAX_VALUE && dis[j]+distance<dis[destiny]){
                        dis[destiny] = dis[j]+distance;
                    }
                }
            }

        }

        System.out.println("The shortest distance between "+src+" and "+dest+" is "+dis[dest]);
    }
}
