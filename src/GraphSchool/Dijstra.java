package GraphSchool;

import java.util.*;

public class Dijstra {

//    public void dijstraAlgo(ArrayList<Edge> graph[],int src,int dest){
//        System.out.println("calling dijstra");
//        int n = graph.length;
//        PriorityQueue<int []> q = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        boolean[] vis = new boolean[n];
//        int[] dis = new int[n];
//        Arrays.fill(dis,Integer.MAX_VALUE);
//        int k = 0;
//        int[] x = {0,src};
//        q.add(x);
//        while(!q.isEmpty()){
//            int []a = q.remove();
//            int node = a[1];
//            int val = a[0];
//            if(!vis[node]){
//                vis[node] = true;
//                dis[node] = val;
//                for(int i=0;i<graph[node].size();i++){
//                    if(!vis[graph[node].get(i).dest]){
//                        int distance = graph[node].get(i).dist;
//                        int destiny = graph[node].get(i).dest;
//                        if(dis[destiny]>distance+val){
//                            int[] arr = {distance+val,destiny};
//                            q.add(arr);
//                            dis[destiny] = distance+val;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(dis[dest]);
//    }

    public void dijstraAlgo(ArrayList<Edge> graph[],int src,int dest){
//        Time Complexity - O(V + E)
        System.out.println("calling dijstra algorithm...");
        int n = graph.length;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        q.add(new Pair(src,0));
        while(!q.isEmpty()){
            Pair a = q.remove();
            int node = a.node;
            int val = a.wt;
            if(!vis[node]){
                vis[node] = true;
                dis[node] = val;
                for(int i=0;i<graph[node].size();i++){
                    if(!vis[graph[node].get(i).dest]){
                        int distance = graph[node].get(i).dist;
                        int destiny = graph[node].get(i).dest;
                        if(dis[destiny]>distance+val){
                            q.add(new Pair(destiny,distance+val));
                            dis[destiny] = distance+val;
                        }
                    }
                }
            }
        }
        System.out.println(dis[dest]);
    }

}
