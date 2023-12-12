package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 07/11/23,Tuesday

import java.util.ArrayList;

public class SumOfUpperAndLowerTriangle {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2},
                {3, 4}};


        System.out.println(sumTriangles(matrix , 2));

    }

    public static ArrayList<Integer> sumTriangles(int[][] matrix, int n)
    {
        var ans = new ArrayList<Integer>();

        int sumUpper = 0 , sumLower = 0;

        for(int i = 0 ; i < n; ++i)
        {
            for(int j = n - 1; j >= 0 ; --j)
            {
                if(j >= (n-1) -(n-1- i))
                {
                    sumUpper += matrix[i][j];
                }

                if(j <= (n-1) - (n-1-i))
                {
                    sumLower += matrix[i][j];
                }
            }
        }

        ans.add(sumUpper);
        ans.add(sumLower);
        return ans;
    }
}
