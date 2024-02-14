package Arrays;

public class LongestSubArrayZeroSum {
//    partially correct
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, -1, 4, -4};
        int len = array.length;
        int maxZero = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int currZero = 0;
            int sum = array[i];
           for (int j = i+1; j < len; j++) {
               sum += array[j];
               if (sum == 0) {
                   currZero++;
                   if (currZero > maxZero) {
                       maxLen = (j - i) + 1;
                       maxZero = currZero;
                   }
               }
           }
        }
        System.out.println(maxLen);
    }
}
