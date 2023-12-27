package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 27/12/23,Wednesday

import java.util.Arrays;

public class AntiDiagonalTraversalOfMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(antiDiagonalPattern(arr)));
    }

    public static int[] antiDiagonalPattern(int[][] matrix)
    {
        int n = matrix.length , idx = 0;

        int[] ans = new int[n*n];
        ans[0] = matrix[0][0];
        idx ++;

        for(int j = 1 ; j < n ; ++j)
        {
            int col = j , row = 0 ;

            while(col >= 0 && row < n)
            {
                ans[idx] = matrix[row][col];
                idx ++;
                col--;
                row ++;
            }
        }

        for(int i = 1 ; i < n ; ++i)
        {
            int col = n-1 , row = i;

            while(col >= 0 && row < n)
            {
                ans[idx] = matrix[row][col];
                idx ++;
                col--;
                row ++;
            }
        }

        return ans;
    }
}
