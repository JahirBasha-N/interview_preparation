package Arrays;

import java.util.HashMap;

public class Unionoftwoarrays {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3};
        int n = 5, m = 3;
        HashMap<Integer, Integer> intIntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            intIntMap.put(i, a[i]);
        }
        for (int j = 0; j < m; j++) {
            intIntMap.put(j, b[j]);
        }
        int size = intIntMap.keySet().size();
        System.out.println(size);
    }
}
