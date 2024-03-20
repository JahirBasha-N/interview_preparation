package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        permutations(0, result, nums);
        System.out.println(result);
    }

    private static void permutations(int index, List<List<Integer>> result, int[] nums) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(new ArrayList<>(current));
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            permutations(index + 1, result, nums);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
