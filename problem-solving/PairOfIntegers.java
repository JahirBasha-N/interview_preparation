import java.util.*;

public class PairOfIntegers {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 11, 15, 2, 7, 3, 6};
        int arrLen = nums.length;
        int targetNum = 9;
        Map<Integer, List<Integer>> numVsIndex = new HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            int subtractTargetNum = targetNum - nums[i];
            if (numVsIndex.containsKey(subtractTargetNum)) {
                System.out.println(numVsIndex.get(subtractTargetNum) + " " + i);
            }
            if (numVsIndex.containsKey(nums[i])) {
                List<Integer> integers = new ArrayList<>(
                        numVsIndex.get(nums[i])
                );
                integers.add(i);
                numVsIndex.put(nums[i], integers);
            } else {
                numVsIndex.put(nums[i], Collections.singletonList(i));
            }

        }
//        for (int i = 0; i < arrLen; i++) {
//            for (int j = i+1; j < arrLen; j++) {
//                if (nums[i] + nums[j] == targetNum) {
//                    System.out.println(i + " " + j);
//                }
//            }
//        }
    }
}
