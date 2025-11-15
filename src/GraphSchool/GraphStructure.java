package GraphSchool;

import java.util.ArrayList;

class Edge{
    int src;
    int dest;
    int dist;
    Edge(int s,int d,int dis){
        this.src = s;
        this.dest = d;
        this.dist = dis;
    }
}

class Pair implements Comparable<Pair>{
    int node;
    int wt;
    Pair(int n,int w){
        this.node = n;
        this.wt = w;
    }

    @Override
    public int compareTo(Pair p) {
        return this.wt - p.wt;
    }
}
public class GraphStructure {
    public static void createGraph(ArrayList<Edge> graph[],int[][] adjacent){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i< adjacent.length;i++){
            for(int j=0;j< adjacent.length;j++){
                if(adjacent[i][j]!=0){
                    graph[i].add(new Edge(i,j,adjacent[i][j]));
                }
            }
        }
    }

    public static void printNeighbour(ArrayList<Edge> graph[],int n){
        System.out.println("printiong all neighbours of "+n);
        for(int i=0;i<graph[n].size();i++){
            System.out.print(graph[n].get(i).dest + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
//        int[][] adjacent1 = {{0,1,3,0,0,0,0},
//                            {1,0,0,2,0,0,0},
//                            {3,0,0,0,2,0,0},
//                            {0,2,0,0,1,2,0},
//                            {0,0,2,1,0,3,0},
//                            {0,0,0,2,3,0,5},
//                            {0,0,0,0,0,5,0}
//        };
//        ArrayList<Edge> graph[] = new ArrayList[adjacent1.length];
//        createGraph(graph,adjacent1);

        int[][] adjacent2 = {
                {0,5,4,0},
                {0,0,-2,-1},
                {0,0,0,2},
                {0,0,0,0}
        };

        ArrayList<Edge> graph[] = new ArrayList[adjacent2.length];
        createGraph(graph,adjacent2);

//        printing neighbours --

//        printNeighbour(graph,0);
//        printNeighbour(graph,1);
//        printNeighbour(graph,2);
//        printNeighbour(graph,3);

//        BFS traversal --

//        BFS.bfs(graph);
//        System.out.println();

//      DFS traversal --

//        DFS d = new DFS();
//        d.dfs(graph,0);


//        AllPath.allPaths(graph,1,3);

//        Dijstra d = new Dijstra();
//        d.dijstraAlgo(graph,0,2);

//        Bellman Ford algorithm
        BellmanFord.bellmanFord(graph,0,2);
    }
}
