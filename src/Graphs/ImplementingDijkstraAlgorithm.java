package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 23/11/23,Thursday

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ImplementingDijkstraAlgorithm {

    public static void main(String[] args) {

    }


    public static class Edge
    {
        int source ;
        int neighbour ;
        int weight;

        Edge(int source , int neighbour , int weight)
        {
            this.source = source;
            this.neighbour = neighbour;
            this.weight  = weight;
        }
    }

    public static class Pair implements Comparable<Pair>
    {
        int v ;
        int w;
        Pair(int v , int w)
        {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Pair o)
        {
            return this.w - o.w;
        }
    }
    public static int[] dijkstra(int v , ArrayList<ArrayList<ArrayList<Integer>>> adj , int s)
    {

        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0 ; i < v ; ++i)
        {
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0 ; i < adj.size() ; ++i)
        {
            var ver = adj.get(i);

            for(int j = 0 ; j < ver.size() ; ++j)
            {
                int neigh = ver.get(j).get(0) , w = ver.get(j).get(1);

                graph[i].add(new Edge(i , neigh , w));
                graph[neigh].add(new Edge(neigh , i , w));
            }
        }

        int[] ans = new int[v];
        Arrays.fill(ans , Integer.MAX_VALUE);
        ans[s] = 0;
        boolean[] visited = new boolean[v];

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(s , 0));

        while(!pq.isEmpty())
        {
            Pair top = pq.remove();

            if(visited[top.v])continue;

            visited[top.v] = true;
            ans[top.v] = top.w;

            for(Edge e : graph[top.v])
            {
                if(!visited[e.neighbour])
                {
                    pq.add(new Pair( e.neighbour , top.w + e.weight));
                }
            }
        }

        return ans;
    }
}
