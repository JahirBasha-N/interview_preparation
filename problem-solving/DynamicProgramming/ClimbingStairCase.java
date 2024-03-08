package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairCase {
    public static void main(String[] args) {
        int stairs = 5; // 1 step or two steps
        int[] dpArray = new int[stairs + 1];
        for (int i = stairs; i >=0; i--) {
            if (i == stairs || i == stairs - 1) {
                dpArray[i] = 1;
            } else {
                dpArray[i] = dpArray[i + 1] + dpArray[i + 2];
            }
        }
        System.out.println(Arrays.toString(dpArray));
        System.out.println(dpArray[0]);
    }
}
