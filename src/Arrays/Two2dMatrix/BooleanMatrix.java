package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 30/09/23,Saturday

import java.util.Arrays;

public class BooleanMatrix {

    public static void main(String[] args) {

        int matrix[][] = {{ 0, 0, 0},
                { 0, 1, 0},
                { 1, 0, 0},
                { 0, 0, 0}};

        int row = matrix.length , col = matrix[0].length;

        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 1) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (rows[i] || cols[j]) matrix[i][j] = 1;
            }
        }

        for(int i = 0 ;i < row ; ++i)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
