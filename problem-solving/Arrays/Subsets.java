package Arrays;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<Integer> subset;
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(0, new ArrayList<>(), subsets, nums);
        System.out.println(subsets);
        subset = new ArrayList<>();
        subsets = new ArrayList<>();
        backTrack(0, subset, subsets, nums);
        System.out.println(subsets);
    }

    private static void findSubsets(int index, List<Integer> subset, List<List<Integer>> subsets, int[] nums) {
        subsets.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            findSubsets(i + 1, subset, subsets, nums);
            subset.remove(subset.size() - 1);
        }
    }
    private static void backTrack(int index, List<Integer> subset, List<List<Integer>> subsets, int[] nums) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        backTrack(index + 1, subset, subsets, nums);
        subset.remove(subset.size() - 1);
        backTrack(index + 1, subset, subsets, nums);
    }
}
