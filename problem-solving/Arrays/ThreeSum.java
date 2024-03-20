package Arrays;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Arrays.sort(nums); // -4, -1, -1, 0, 1, 2
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + num;
                if (sum == target) {
                    System.out.println(i + " " + l + " " + r);
                    System.out.println(nums[i] + " " + nums[l] + " " + nums[r]);
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
}
