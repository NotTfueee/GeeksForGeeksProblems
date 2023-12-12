package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 09/11/23,Thursday

public class PredictTheColumn {

    public static void main(String[] args) {

        int [][] arr = {
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1}};

        System.out.println(columnWithMaxZeros(arr , 3));
    }

    public static int columnWithMaxZeros(int[][] arr , int N)
    {
        int max = Integer.MIN_VALUE , ans = 0;

        for(int j = 0  ; j < arr[0].length ; ++j)
        {
            int count = 0 ;
            for(int i = 0 ; i < arr.length ; ++i)
            {
                if(arr[i][j] == 0) count ++;
            }

            if(max < count)
            {
                max = count;
                ans = j;
            }

        }


        if(max == 0)ans = -1;
        return ans;
    }
}
