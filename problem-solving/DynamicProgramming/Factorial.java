package DynamicProgramming;

import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        int[] dpArr = new int[num + 1];
        dpArr[0] = 1;
        for (int i = 1; i <= num; i++) {
            dpArr[i] = i * dpArr[i - 1];
        }
        System.out.println(Arrays.toString(dpArr));
        System.out.println(dpArr[num]);
    }
}
