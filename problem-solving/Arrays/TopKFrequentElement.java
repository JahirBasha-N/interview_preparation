package Arrays;

import java.util.*;

public class TopKFrequentElement {
    public static void main(String[] args) {
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        Map<Integer, Integer> numVsCount = new HashMap<>();
        for (int num : nums) {
            int count = numVsCount.getOrDefault(num, 1) + 1;
            numVsCount.put(num, count);
        }
        ArrayList[] frequency = new ArrayList[nums.length + 1]; // bucketList []
        for (int num : numVsCount.keySet()) {
            int count = numVsCount.get(num);
            if (frequency[count] == null) {
                frequency[count] = new ArrayList();
            }
            frequency[count].add(num);
        }
        List<Integer> sortedFrequency = new ArrayList<>();
        for (int i = frequency.length - 1; i >= 0; i --) {
            if (frequency[i] != null) {
                sortedFrequency.addAll(frequency[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedFrequency.get(i);
        }
        System.out.println(Arrays.toString(result));
    }
}
