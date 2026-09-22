import java.util.*;

public class sliding_window {

    // Maximum sum of any subarray of size k.
    public static int maxSum(int[] arr, int k) {
        if (k <= 0 || k > arr.length) return -1;

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        for (int right = k; right < arr.length; right++) {
            sum += arr[right];
            sum -= arr[right - k];

            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSum(arr, 3)); // 9
    }
}