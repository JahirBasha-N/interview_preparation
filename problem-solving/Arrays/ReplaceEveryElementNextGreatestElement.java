package Arrays;

import java.util.Arrays;

public class ReplaceEveryElementNextGreatestElement {
    public static void main(String[] args) {
//        int[] arr = new int[]{5 ,4 ,3 ,2 ,1 ,0};
        int[] arr = new int[]{1 ,2 ,3 ,4 ,5};
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[len - 1] = -1;
        for (int i = len - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                arr[i - 1] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
