package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 24/01/24,Wednesday

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class IsItATree {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(2, 1)));
        list.add(new ArrayList<>(Arrays.asList(0, 3)));
        list.add(new ArrayList<>(Arrays.asList(2, 2)));
        list.add(new ArrayList<>(Arrays.asList(1, 0)));

        System.out.println(isTree(5 , 4, list));

    }

    public static class Edge
    {
        int src ;
        int neigh;

        Edge(int src , int neigh)
        {
            this.src = src;
            this.neigh = neigh;
        }
    }

    public static boolean isTree(int n , int m , ArrayList<ArrayList<Integer>> edges)
    {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0 ; i < n ; ++i)
        {
            graph[i]  = new ArrayList<Edge>();
        }

        for (ArrayList<Integer> edge : edges) {
            int src = edge.get(0), neigh = edge.get(1);

            graph[src].add(new Edge(src, neigh));
            graph[neigh].add(new Edge(neigh, src));
        }

        boolean[] visited = new boolean[n];
        int connected = 0;
        for(int i = 0 ; i < n ; ++i)
        {
            if(!visited[i])
            {
                var path = new ArrayList<Integer>();
                isConnected(graph , i , visited , path);

                if(!path.isEmpty())connected ++;
            }
        }

        boolean[] v = new boolean[n];

        for(int i = 0 ; i < n ; ++i)
        {
            if(!v[i])
            {
                if(isCyclic(graph , i , v))return false;
            }
        }

        return connected == 1;
    }

    public static void isConnected(ArrayList<Edge>[] graph , int src , boolean[] visited , ArrayList<Integer> path)
    {
        visited[src] = true;
        path.add(src);

        for(Edge e : graph[src])
        {
            if(!visited[e.neigh])
            {
                isConnected(graph , e.neigh , visited , path);
            }
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph , int src , boolean[] v )
    {
        var q = new ArrayDeque<Integer>();
        q.add(src);

        while(!q.isEmpty())
        {
            int top = q.remove();

            if(v[top])return true;

            v[top] = true;

            for(Edge e : graph[top])
            {
                if(!v[e.neigh])
                {
                    q.add(e.neigh);
                }
            }
        }

        return false;
    }
}
