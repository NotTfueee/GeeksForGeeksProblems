package Recursion.BackTracking;

public class FloodFill {

    public static void main(String [] args)
    {
        int [][] board =  {{1,1,1},{1,1,0},{1,0,1}};

        floodFill(board , 1, 1, 2);

    }

    public static void floodFill(int[][] board , int startRow , int startCol , int color ) {
        if (startRow < 0 || startCol < 0 || startRow >= board.length || startCol >= board.length || board[startRow][startCol] != color )
        {
            return ;
        }


    }
}
