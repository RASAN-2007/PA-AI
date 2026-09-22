import java.util.*;

public class find_all_subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private static void generate(int index, int[] nums,
                                 List<Integer> current,
                                 List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Do not take nums[index]
        generate(index + 1, nums, current, ans);

        // Take nums[index]
        current.add(nums[index]);
        generate(index + 1, nums, current, ans);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}