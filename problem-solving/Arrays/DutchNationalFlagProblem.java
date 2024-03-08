package Arrays;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] array   = new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int len = array.length;
        int l = 0, r = len -1;
        while (l < r) {
            while (array[l] == 0 && l < r) {
                l++;
            }
            while (array[r] == 1 && l < r) {
                r--;
            }
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
        System.out.println(Arrays.toString(array));
    }
}
