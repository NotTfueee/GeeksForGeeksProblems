package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 08/11/23,Wednesday

import java.util.ArrayList;

public class PrintMatrixInSnakePattern {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2},
                {3, 4}};

        System.out.println(snakePattern(matrix));

    }

    public static ArrayList<Integer> snakePattern(int[][] matrix)
    {
        var ans = new ArrayList<Integer>();

        int flip = 0 ;

        for(int i = 0 ; i < matrix.length ; ++i)
        {
            if(flip == 0 )
            {
                for(int j = 0 ; j < matrix.length ; ++j)ans.add(matrix[i][j]);
            }
            else
            {
                for(int j = matrix.length-1 ; j >= 0 ; --j)ans.add(matrix[i][j]);
            }
            flip ^= 1;
        }


        return ans;
    }
}
