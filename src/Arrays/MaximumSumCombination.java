package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 25/09/23,Monday


import java.util.*;

public class MaximumSumCombination {

    public static void main(String[] args) {

        int [] a = {1, 4, 2, 3};
        int [] b = {2, 5, 1, 6};

        System.out.println(combination(4 , 3 , a , b));
    }

    public static List<Integer> combination(int N , int K , int a[] , int[] b)
    {
        var ans = new ArrayList<Integer>();
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        Arrays.sort(a);
        Arrays.sort(b);


        return ans;
    }
}
