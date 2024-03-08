package Matrix;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Thread thread = new Thread(() -> System.out.println(Arrays.deepToString(matrix)));
        Thread thread1 = new Thread(SpiralMatrix.print(matrix));
        thread.start();
        thread1.start();
    }

    private static Runnable print(int[][] matrix) {
        return () -> System.out.println(Arrays.deepToString(matrix));
    }
}
