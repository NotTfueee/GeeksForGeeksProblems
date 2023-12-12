package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 01/10/23,Sunday

import java.util.ArrayList;

public class BoundaryTraversalOfMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4}
        };

        System.out.println(boundaryTraversal(matrix , 1 , 4));
    }

    public static ArrayList<Integer> boundaryTraversal(int[][]matrix , int n , int m ) {

        var ans = new ArrayList<Integer>();

        int i = 0 , j = 0 ;

        if(n == 1 || m == 1)
        {
            if(n ==1)
            {
                while(j < m )
                {
                    ans.add(matrix[i][j]);
                    j++;
                }
            }
            else
            {
                while(i < n )
                {
                    ans.add(matrix[i][j]);
                    i++;
                }
            }

            return ans;
        }


        while(j < m)
        {
            ans.add(matrix[i][j]);
            j++;
        }

        j--;
        i++;

        while(i < n )
        {
            ans.add(matrix[i][j]);
            i++;
        }

        i--;
        j--;
        while(j > 0 )
        {
            ans.add(matrix[i][j]);
            j--;
        }

        while(i > 0)
        {
            ans.add(matrix[i][j]);
            i--;
        }


        return ans;
    }
}
