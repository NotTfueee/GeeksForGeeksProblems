package Arrays;

public class NumberOfOccurence {

    public static void main(String[] args)
    {
        int[] a = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(count(a, 7 , 2));
    }

    public static int count(int[] arr , int n , int x)
    {
        int count = 0 , left = 0 , right = n - 1;

        while(left <= right)
        {
            int mid = (right+left)/2;

            if(arr[mid] == x)
            {
                int base = mid ;

                while(mid < n && arr[mid] == x)
                {
                    count++;
                    mid++;
                }

                while(base >= 0 && arr[base] == x)
                {
                    count++;
                    base--;
                }

                return count-1;
            }
            else if(x > arr[mid])left = mid+1;
            else right = mid-1;
        }

        return 0;
    }
}
