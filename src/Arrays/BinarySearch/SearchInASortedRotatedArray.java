package Arrays.BinarySearch;

//File Created by -- > anuragbhatt
//Created On -- > 16/12/23,Saturday

public class SearchInASortedRotatedArray {

    public static void main(String[] args) {

        int[] arr = {12,13,14,15,16 , 9 , 10 , 11};

        System.out.println(search( arr , 10 , 0 , 7));
    }

    public static int search(int[] arr , int key , int l , int r)
    {

        while(l <= r )
        {
            int mid = (l + r ) / 2;

            if(arr[mid] == key)return mid;

            // we check if the elements on the left side of the array are sorted or not by check if mid is greater than or equal to the left
            else if(arr[l] <= arr[mid])
            {
                /*
                if the key is less than the mid and greater than or equal to the left value then we will check on the left side
                otherwise on the right side;
                 */
                if(key < arr[mid] && key >= arr[l]) r = mid - 1;
                else l = mid + 1;
            }

            // we check if the right side of the array is sorted or not by checking if the last element is greater than the mid
            else if(arr[r] >= arr[mid])
            {
                /*
                if the key is greater than the mid but less than the right side we will check on the right side if it is not
                we will check on the left side of the array
                 */
                if(key > arr[mid] && key <= arr[r]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return -1;
    }
}
