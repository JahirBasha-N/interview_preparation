package Arrays;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class HappyNeighborhood {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of houses
        int N = scanner.nextInt();

        // Input: Number of consecutive houses needed
        int M = scanner.nextInt();

        // Input: Array representing houses to be occupied each day
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = scanner.nextInt();
        }

        // Find the first day the neighborhood becomes happy
        int firstHappyDay = findFirstHappyDay(N, M, houses);
        System.out.println(firstHappyDay);
    }

    private static int findFirstHappyDay(int N, int M, int[] houses) {
        int firstHappyDay = -1;

        for (int i = 0; i <= N - M; i++) {
            boolean isConsecutive = true;
            for (int j = i + 1; j < i + M; j++) {
                if (houses[j] != houses[j - 1] + 1) {
                    isConsecutive = false;
                    break;
                }
            }
            if (isConsecutive) {
                firstHappyDay = i + 1; // Day index starts from 1
                break;
            }
        }

        return firstHappyDay;
    }
}




