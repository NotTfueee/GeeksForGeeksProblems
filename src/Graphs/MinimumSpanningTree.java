package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 26/11/23,Sunday

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    public static void main(String[] args) {

        int[][] edges = {{0 , 1, 5} };

        System.out.println(spanningTree(2 , 1, edges));
    }


    public static class Edge
    {
        int source ;
        int neighbour ;
        int weight ;

        Edge(int source , int neighbour , int weight)
        {
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
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
    public static int spanningTree(int v , int E , int[][] edges)
    {
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0 ; i < v ; ++i)
        {
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0 ; i < E ; ++i)
        {
            int s = edges[i][0] , n = edges[i][1] , w = edges[i][2];

            graph[s].add(new Edge(s , n , w));
            graph[n].add(new Edge(n , s , w));
        }

        boolean[] visited = new boolean[v];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0 , 0));
        int sum = 0;

        while(!pq.isEmpty())
        {
            Pair top = pq.remove();

            if(visited[top.v])continue;

            visited[top.v] = true;

            sum += top.w;

            for(Edge e : graph[top.v])
            {
                if(!visited[e.neighbour])
                {
                    pq.add(new Pair(e.neighbour , e.weight));
                }
            }
        }

        return sum;
    }
}
