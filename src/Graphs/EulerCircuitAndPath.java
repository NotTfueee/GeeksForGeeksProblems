package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 29/11/23,Wednesday

import java.util.List;

public class EulerCircuitAndPath {

    public static void main(String[] args) {

    }

    public static int isEulerCircuit(int v , List<Integer>[] adj)
    {
        boolean isPath = false;

        for(int i = 0 ; i < v ; ++i)
        {
            boolean isCircuit = false;
            boolean[] visited = new boolean[v];
            check(adj , i , v , 1 , i , visited , isCircuit , isPath);
            if(isCircuit)return 2;
        }

        if(isPath)return 1;
        else return 0;
    }

    public static void check(List<Integer>[] adj , int src , int totalVertex , int count , int startPoint , boolean[] visited , boolean isCircuit , boolean isPath)
    {

        if(count == totalVertex)
        {
            isPath = true;

            for(int e : adj[src])
            {
                if(e == startPoint)isCircuit = true;
            }

            return ;
        }

        visited[src] = true;

        for(int e : adj[src])
        {
            if(!visited[e])
            {
                check(adj , e , totalVertex , count + 1 , startPoint , visited , isCircuit , isPath);
            }
        }

        visited[src] = false;
    }
}
