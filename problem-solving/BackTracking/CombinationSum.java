package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,5};
        int target = 8;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(0, current, result, target, candidates, 0);
        System.out.println(result);
    }

    private static void combinationSum(int index, List<Integer> current, List<List<Integer>> result, int target, int[] candidates, int currentSum) {
        if (index == candidates.length || currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        currentSum += candidates[index];
        current.add(candidates[index]);
        combinationSum(index, current, result, target, candidates, currentSum);
        currentSum -= candidates[index];
        current.remove(current.size() - 1);
        combinationSum(index + 1, current, result, target, candidates, currentSum);
    }
}
