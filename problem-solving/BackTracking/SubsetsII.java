package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        distinctSubset(0, result, current, nums);
        System.out.println(result);
    }

    private static void distinctSubset(int index, List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        distinctSubset(index + 1, result, current, nums);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) index++;
        current.remove(current.size() - 1);
        distinctSubset(index + 1, result, current, nums);
    }
}
