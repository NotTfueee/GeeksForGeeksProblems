package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 28/11/23,Tuesday

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {

    }

    public static int[] topoSort(int v , ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[v];

        var stack = new Stack<Integer>();

        for(int i = 0 ; i < adj.size() ; ++i)
        {
            if(!visited[i])
            {
                check(adj , i, visited, stack);
            }
        }

        int [] ans = new int[v];
        int i = 0;
        while(!stack.isEmpty())
        {
            ans[i] = stack.pop();
            i++;
        }

        return ans ;
    }

    public static void check(ArrayList<ArrayList<Integer>> adj , int src , boolean[] visited , Stack <Integer> stack)
    {
        visited[src] = true;

        for(int e : adj.get(src))
        {
            if(!visited[e])
            {
                check(adj, e ,visited , stack);
            }
        }

        stack.push(src);
    }
}
