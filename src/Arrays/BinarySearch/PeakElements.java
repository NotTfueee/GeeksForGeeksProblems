package Arrays.BinarySearch;

public class PeakElements {

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeak(a));
    }

    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right)
        {
            int mid = (left + right)/2;

            if(arr[mid] > arr[mid+1])
                right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
