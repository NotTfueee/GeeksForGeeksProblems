package Recursion;

//File Created by -- > anuragbhatt
//Created On -- > 23/10/23,Monday

public class NumberOfPaths {

    public static void main(String[] args) {

        System.out.println(noOfPaths(10 ,100000000));
    }

    public static long noOfPaths(int M , int N )
    {
        return paths(1 , 1 , M , N );
    }

    public static long paths(int startRow , int startCol , int finalRow , int finalCol )
    {
        if(startRow > finalRow || startCol > finalCol)return 0;

        if(startRow == finalRow && startCol == finalCol)
        {
            return 1;
        }

        long down = paths(startRow+1 , startCol , finalRow , finalCol );
        long right = paths(startRow , startCol + 1 , finalRow , finalCol );

        return (down + right) % 1000000007;
    }
}
