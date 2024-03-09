package Algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 6, 3, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = (arr.length) / 2;

            int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
            int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(leftArr);
            mergeSort(rightArr);

            merge(arr, leftArr, rightArr);
        }
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++; k++;
        }
        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++; k++;
        }
    }
}
