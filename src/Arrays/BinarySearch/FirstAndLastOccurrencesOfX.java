package Arrays.BinarySearch;

//File Created by -- > anuragbhatt
//Created On -- > 25/09/23,Monday

import java.util.ArrayList;

public class FirstAndLastOccurrencesOfX {

    public static void main(String[] args) {


        int [] arr = { 5,7 ,7, 8,8 ,10 };
        System.out.println(find(arr , 6 , 6));
    }

    public static ArrayList<Integer> find(int [] arr , int n , int x)
    {
        var ans = new ArrayList<Integer>();
        int left = 0 , right = n - 1;

        while(left <= right)
        {
            int mid = (left + right)/2;

            if(x == arr[mid])
            {
                int pointer = mid;

                while( pointer >= left && arr[pointer] == x )
                {
                    pointer--;
                }
                ans.add(++pointer);

                pointer = mid;

                while(pointer <= right && arr[pointer] == x )
                {
                    pointer++;
                }

                ans.add(--pointer);
                break;
            }
            else if (x > arr[mid])left = mid+1;
            else right = mid -1;
        }

        if(ans.isEmpty())
        {
            ans.add(-1);
            ans.add(-1);
        }
        return ans;
    }
}
