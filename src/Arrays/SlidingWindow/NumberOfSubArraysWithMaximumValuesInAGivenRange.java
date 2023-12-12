package Arrays.SlidingWindow;

//File Created by -- > anuragbhatt
//Created On -- > 07/12/23,Thursday

public class NumberOfSubArraysWithMaximumValuesInAGivenRange {

    public static void main(String[] args) {

        int[] a = {1,1,3,1,1,2,3};

        System.out.println(countSubarray(a , a.length , 3 , 3));
    }

    public static long countSubarray(int[] a , int n , int l , int r)
    {
        long inRangeSubarrays = 0 , start = 0 , ans = 0;

        for(int i = 0 ; i < n ; ++i)
        {

            /*
            we can only create a subarray with the element that is in range and to find the number of subarray in a given
            range we have the formula i - start + 1 which tell us how many subarray within a range can be formed
             */
            if(a[i] >= l && a[i] <= r)inRangeSubarrays = i - start + 1;
            /*
            now when the element we are at goes out of range we cannot create a subarray using that array so we make the
            previous subarray count = 0 meaning that we cannot make any subarray using the current element and move the start
            pointer to i + 1
             */
            else if(a[i] > r)
            {
                inRangeSubarrays = 0 ;
                start = i+1;
            }

            /*
            and when the element is less than the given range we know that the element cannot be used as a single subarray as it would
            be the only element which would be the maximum and minimum at the same time and would not fall in the range

            so we can only use this element whenever we have an element that falls within the given range so when we encounter the
            element less than the range we simply can add this element to the previous subarray which were created using elements that
             followed the rules or else we can do nothing new with this element so we simply add the previously formed subarray to the ans
             */
            ans += inRangeSubarrays;
        }

        return ans;
    }
}
