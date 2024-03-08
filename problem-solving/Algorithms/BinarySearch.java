package Algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int len = nums.length;
        int l = 0, r = len -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                System.out.println(m);
                break;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
}
