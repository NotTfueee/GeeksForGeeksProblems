package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 20/11/23,Monday

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DetectCycleInAUndirectedGraph {

    public static void main(String[] args) {


    }

    public static boolean isCycle(int v , ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[adj.size()];

        for(int i = 0 ; i < v ; ++i)
        {
            if(!visited[i])
            {
                if(isPresent(adj , i , visited))return true;
            }
        }
        return false;
    }

    public static boolean isPresent(ArrayList<ArrayList<Integer>> graph ,int src , boolean[] visited)
    {
        var q = new ArrayDeque<Integer>();
        q.add(src);

        while(!q.isEmpty())
        {
            int top = q.remove();

            if(visited[top])return true;

            visited[top] = true;

            for(var e : graph.get(top))
            {
                if(!visited[e])
                {
                    q.add(e);
                }
            }
        }

        return false;
    }
}
