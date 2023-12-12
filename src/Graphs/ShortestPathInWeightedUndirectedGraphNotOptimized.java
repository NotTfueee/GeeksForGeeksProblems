package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 08/11/23,Wednesday

import java.util.ArrayList;

public class ShortestPathInWeightedUndirectedGraphNotOptimized {

    public static void main(String[] args) {

        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};

        System.out.println(shortestPath(5 , 6, edges));
    }


    public static class Edge
    {
        int source ;
        int neighbour;
        int weight;

        Edge(int source , int neighbour , int weight)
        {
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    static int smallest ;
    public static ArrayList<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; ++i) {
            int s = edges[i][0];
            int ne = edges[i][1];
            int w = edges[i][2];

            graph[s].add(new Edge(s, ne, w));
            graph[ne].add(new Edge(ne, s, w));
        }

        boolean[] visited = new boolean[n + 1]; // Initialize visited array with size n + 1
        smallest = Integer.MAX_VALUE;
        var ans = new ArrayList<Integer>();

        shortest(graph, 1, n, 0, new ArrayList<>(), visited, ans);

        if (!ans.isEmpty()) return ans;
        else {
            ans.add(-1);
            return ans;
        }
    }


    public static void shortest(ArrayList<Edge>[] graph , int src , int dst ,int weight , ArrayList<Integer> path, boolean[] visited , ArrayList<Integer> ans)
    {
        if(src == dst)
        {
            if(smallest > weight)
            {
                smallest = weight ;
                var shortest = new ArrayList<Integer>(path);
                shortest.add(src);
                ans.clear();
                ans.addAll(shortest);
            }
            return;
        }

        visited[src] = true;

        for(Edge e : graph[src])
        {
            if(!visited[e.neighbour])
            {
                path.add(src);
                shortest(graph , e.neighbour , dst , weight + e.weight , path , visited , ans);
                path.remove(path.size() -1);
            }
        }

        visited[src] = false;
    }
}
