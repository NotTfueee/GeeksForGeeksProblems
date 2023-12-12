package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 17/11/23,Friday

import java.util.ArrayList;

public class HamiltonianPath {

    public static class Edge
    {
        int source ;
        int neighbour ;

        Edge(int source , int neighbour)
        {
            this.source = source ;
            this.neighbour = neighbour;
        }
    }

    public static void main(String[] args) {

    }

    public static boolean check(int n , int m , ArrayList<ArrayList<Integer>> edges)
    {

        // the number of vertexes in the graph
        int vertices = n + 1;

        // now we create a array of array list which will store our source and neighbour of each vertex
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // we are initializing the array of array list as earlier it was null now we've created arraylist of edges
        for(int i = 0 ; i < vertices ; ++i)
        {
            graph[i] = new ArrayList<Edge>();
        }

        //now we extract the source and neighbours and create an adjacency list
        for(int i = 0; i < edges.size() ; ++i)
        {
            int s = edges.get(i).get(0) , ne = edges.get(i).get(1);

            graph[s].add(new Edge( s , ne));
            graph[ne].add(new Edge( ne , s));
        }

        /*
        now we need to check if there exists a hamiltonian path in the graph it can be from any vertex as we do not know the
        vertex we will run it for all the vertices until we find a path and then we stop
         */

        for(int i = 1 ; i < vertices ; ++i)
        {
            /*
            we are creating a boolean array here as for each vertex after completing the previous recursion we will be
            changing our src vertex and we need to start fresh with each vertex being passed as a source . we will check if the
            count of the nodes visited is equal to
             */

            boolean[] visited = new boolean[vertices];
            if(find(graph , i , visited , 1 , n))return true;
        }

        return false;
    }

    public static boolean find(ArrayList<Edge>[] graph , int src , boolean[] visited , int count , int n)
    {
        if(count == n)return true;

        visited[src] = true;

        for(Edge e : graph[src])
        {
            if(!visited[e.neighbour])
            {
                if(find(graph , e.neighbour , visited , count + 1 , n))return true;
            }
        }

        visited[src] = false;

        return false;
    }

}

