package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 16/12/23,Saturday

import java.util.ArrayList;

public class SpirallyTraversingTheMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15,16}
        };

        System.out.println(spirallyTraverse(matrix , matrix.length , matrix[0].length));
    }

    public static ArrayList<Integer> spirallyTraverse(int[][] matrix , int r , int c)
    {
        var ans = new ArrayList<Integer>();
        int n = matrix.length , m = matrix[0].length;
        int count = 0 ;

        int left = 0 , right = m - 1 , top = 0 , bottom = n-1 ;

        while(count < r*c)
        {
            for(int i = left ; i <= right && count < r * c ; ++i)
            {
                ans.add(matrix[top][i]);
                count ++;
            }
            top ++;

            for(int i = top ; i <= bottom && count < r * c ; ++i)
            {
                ans.add(matrix[i][right]);
                count ++;
            }
            right --;

            for(int i = right ; i >= left && count < r*c ; --i)
            {
                ans.add(matrix[bottom][i]);
                count ++;
            }
            bottom--;

            for(int i = bottom ; i >= top && count < r*c ; --i)
            {
                ans.add(matrix[i][left]);
                count++;
            }
            left ++;
        }
        return ans;
    }
}
