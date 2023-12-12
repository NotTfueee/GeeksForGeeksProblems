package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SumOfDistinctElements {

    public static void main(String[] args)
    {
        int[] a = {1, 2, 2 ,3, 4, 5};
       System.out.println(sumUniqueSubarrays(a));

    }
    public static int sumUniqueSubarrays(int[] A) {
        int n = A.length;
        int left = 0;
        int result = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        int[] frequency = new int[101]; // Assuming elements in A are between 1 and 100

        for (int right = 0; right < n; right++) {
            while (uniqueElements.contains(A[right])) {
                uniqueElements.remove(A[left]);
                left++;
            }
            uniqueElements.add(A[right]);

            // Count unique elements from left to right
            for (int i = left; i <= right; i++) {
                frequency[A[i]]++;
            }

            // Add the count of unique elements to the result
            for (int element : uniqueElements) {
                result += frequency[element];
                frequency[element] = 0; // Reset frequency for this element
            }
        }

        return result;
    }
}
