package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args)
    {
        int [] arr = {7,10,4,20,15};
        System.out.println(smallest(arr , 4 ));
    }

    public static int smallest (int[] arr , int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++)
        {
            if(min > arr[i])
            {
                min = arr[i];
                maxHeap.add(min);
            }

            if(maxHeap.size() == k)break;
        }

        return maxHeap.peek();
    }
}
