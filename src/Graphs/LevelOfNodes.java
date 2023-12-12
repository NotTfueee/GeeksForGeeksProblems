package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 20/11/23,Monday

import java.util.ArrayDeque;
import java.util.ArrayList;

public class LevelOfNodes {

    public static void main(String[] args) {

    }

    public static int nodeLevel(int v , ArrayList<ArrayList<Integer>> adj , int target)
    {
        boolean[] visited = new boolean[v];

        return bfs(adj , 0 , target , visited);
    }

    public static int bfs(ArrayList<ArrayList<Integer>> graph , int src , int target , boolean[] visited)
    {
        var q = new ArrayDeque<Integer>();
        int level = 0 ;
        q.add(src);

        while(!q.isEmpty())
        {
            int size = q.size() , k = size;

            while(size-- > 0)
            {
                int top = q.remove();

                if(top == target)return level;
                if(visited[top])continue;

                visited[top] = true;

                for(int e : graph.get(top))
                {
                    if(!visited[src])
                    {
                        q.add(e);
                    }
                }
            }

            level ++;
        }

        return -1;
    }
}
