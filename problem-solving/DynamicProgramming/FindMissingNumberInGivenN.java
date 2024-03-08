package DynamicProgramming;

import java.util.Arrays;

public class FindMissingNumberInGivenN {
    public static void main(String[] args) {
        int n = 5;
        int[] num = new int[]{1,2,4,5};
        int len = num.length;
        int[] dpArr = new int[n + 1];
        dpArr[0] = 0;
        for (int i = 1; i <= n; i++) {
            dpArr[i] = i + dpArr[i - 1];
        }
        int sumAll = 0;
        for (int numb : num) {
            sumAll += numb;
        }
        System.out.println(Arrays.toString(dpArr));
        System.out.println(dpArr[n] - sumAll);
    }
}
