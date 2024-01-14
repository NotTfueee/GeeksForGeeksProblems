package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 14/01/24,Sunday

import java.util.ArrayList;
import java.util.HashSet;

public class FindDuplicateRowsInABinaryMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 0, 0},
                { 1, 0, 0},
                { 0, 0, 0},
                { 0, 0, 0}};

        System.out.println(repeatedRows(matrix , 4 , 3));

    }

    public static ArrayList<Integer> repeatedRows(int[][] matrix , int m , int n )
    {
        var set = new HashSet<String>();
        var ans = new ArrayList<Integer>();

        for(int i = 0 ; i < m ; ++i)
        {
            StringBuilder s = new StringBuilder();
            for(int j = 0 ; j < n ; ++j)
            {
                s.append(matrix[i][j]);
            }
            if(set.contains(s.toString()))ans.add(i);
            else set.add(s.toString());
        }

        return ans;
    }
}
