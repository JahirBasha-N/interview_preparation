package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsets(0, result, current, nums);
        System.out.println(result);
    }

    private static void subsets(int index, List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subsets(index + 1, result, current, nums);
        current.remove(current.size() - 1);
        subsets(index + 1, result, current, nums);
    }
}
