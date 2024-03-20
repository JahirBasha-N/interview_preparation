package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(0, result, current, candidates, 0, target);
        System.out.println(result);
    }
    private static void combinationSum(int index, List<List<Integer>> result, List<Integer> current,
                                       int[] candidates, int curSum, int target) {
        if (curSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length || curSum > target) {
            return;
        }

        current.add(candidates[index]);
        combinationSum(index + 1, result, current, candidates, curSum + candidates[index], target);
        current.remove(current.size() - 1);

        while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }

        combinationSum(index + 1, result, current, candidates, curSum, target);
    }
}
