package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 28/11/23,Tuesday

import java.util.ArrayList;

public class DetectCycleInADirectedGraph {

    public static void main(String[] args) {

    }

    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adj , int v )
    {
        // this will check for the main loop whether we have visited the node or not
        boolean[] visited = new boolean[v];

        /*
         this will check if the current node is already present for the current continuous recursion if yes this means
          a cycle is present
         */
        boolean[] recursionStack = new boolean[v];

        for(int i = 0 ; i < adj.size() ; ++i)
        {
            if(!visited[i])
            {
                if(check(adj , i , visited , recursionStack))return true;
            }
        }

        return false;
    }

    public static boolean check(ArrayList<ArrayList<Integer>> adj , int src , boolean[] visited , boolean[] recursionStack)
    {
        visited[src] = true;
        recursionStack[src] = true;

        for(int e : adj.get(src))
        {
            if(!visited[e])
            {
                if(check(adj , e , visited , recursionStack))return true;
            }
            else if(recursionStack[e])return true;
        }

        recursionStack[src] = false;

        return false;
    }
}
