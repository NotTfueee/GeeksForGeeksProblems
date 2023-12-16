package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 16/12/23,Saturday

import java.util.ArrayList;

public class NumberOfProvinces {

    public static void main(String[] args) {

    }

    public static class Edge
    {
        int source ;
        int neighbour ;

        Edge(int source , int neighbour)
        {
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        int v = adj.size() ;

        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0 ; i < v ; ++i)
        {
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0 ; i < v; ++i)
        {
            int s = i , neigh = 0;

            for(int j = 0 ; j < adj.get(i).size() ; ++j)
            {
                if(i != j && adj.get(i).get(j) == 1)
                {
                    neigh = j ;

                    graph[s].add(new Edge(s , neigh));
                    graph[neigh].add(new Edge(neigh , s));
                }
            }
        }


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[v];


        for(int i = 0 ; i < v ; ++i)
        {
            if(!visited[i])
            {
                var comp = new ArrayList<Integer>();
                isConnected(graph , i , visited , comp);
                ans.add(comp);
            }
        }

        return ans.size();
    }


    public static void isConnected(ArrayList<Edge>[] graph , int src , boolean[] visited , ArrayList<Integer> comp)
    {
        visited[src] = true;

        for(Edge e : graph[src])
        {
            if(!visited[e.neighbour])
            {
                isConnected(graph , e.neighbour , visited , comp);
            }
        }
    }
}
