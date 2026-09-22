import java.util.*;

public class Find_First_and_Last_Position_of_Element {
    public static int[] searchRange(int[] nums, int target) {
        int first = firstPosition(nums, target);
        int last = lastPosition(nums, target);
        return new int[]{first, last};
    }

    private static int firstPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static int lastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8))); // [3, 4]
    }
}