package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 23/01/24,Tuesday

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CourseSchedule {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        list.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
        list.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        list.add(new ArrayList<Integer>(Arrays.asList(3, 1)));
        list.add(new ArrayList<Integer>(Arrays.asList(3, 2)));

        System.out.println(Arrays.toString(findOrder(4, 4, list)));

    }

    public static class Edge {
        int src;
        int neigh;

        Edge(int src, int neigh) {
            this.src = src;
            this.neigh = neigh;
        }
    }

    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> preq) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<Edge>();
        }

        for (ArrayList<Integer> integers : preq) {
            int src = integers.get(0), neigh = integers.get(1);

            graph[src].add(new Edge(src, neigh));
        }

        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        var stack = new Stack<Integer>();

        for(int i = 0 ; i < n ; ++i)
        {
            if(!visited[i])
            {
                boolean result = find(graph , i , visited , visiting, stack);
                if(!result)
                {
                    // Cycle detected, so no ordering is possible
                    return new int[]{};
                }
            }
        }

        int size = stack.size();

        int[] ans = new int[size];

        for (int i = size - 1; i >= 0; --i) {
            ans[i] = stack.pop();
        }

        return ans;
    }

    public static boolean find(ArrayList<Edge>[] graph , int src , boolean[] visited, boolean[] visiting, Stack<Integer> stack)
    {
        visiting[src] = true;

        for(Edge e : graph[src])
        {
            if(!visited[e.neigh])
            {
                if(visiting[e.neigh])
                {
                    // Cycle detected
                    return false;
                }

                boolean result = find(graph , e.neigh , visited , visiting, stack);
                if(!result)
                {
                    // Cycle detected in recursive call
                    return false;
                }
            }
        }

        visiting[src] = false;
        visited[src] = true;
        stack.push(src);

        return true;
    }

}
