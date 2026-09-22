import java.util.*;

public class sliding_window2 {

    // Longest subarray with sum <= k.
    // Assumes all array elements are non-negative.
    public static int longestSubarray(int[] arr, int k) {
        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k && left <= right) {
                sum -= arr[left++];
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        System.out.println(longestSubarray(arr, 4));
    }
}