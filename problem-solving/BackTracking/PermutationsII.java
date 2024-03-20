package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// not solved
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> result = new ArrayList<>();
        distinctPermutation(0, nums, result);
        System.out.println(result);
    }

    private static void distinctPermutation(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (index != i && sameRecursion(index, i, nums)) {
                continue;
            }
            swap(index, i, nums);
            distinctPermutation(index + 1, nums, result);
            swap(index, i, nums);
        }
    }

    private static boolean sameRecursion(int index, int i, int[] nums) {
        for (int s = index; s < i; s++) {
            if (nums[s] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    private static void swap(int index, int i, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
