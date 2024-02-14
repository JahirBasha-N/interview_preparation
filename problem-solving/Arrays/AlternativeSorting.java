package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AlternativeSorting {
    public static void main(String[] args) {
        int N = 7;
        long[] arr = {7, 1, 2, 3, 4, 5, 6};

        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int inc = 0;
        int dec = N - 1;
        for(int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                list.add(i, arr[dec--]);
            } else {
                list.add(i, arr[inc++]);
            }
        }
        list.size();

        System.out.println(list);
    }
}
