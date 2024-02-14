package Arrays;

import java.util.*;
//public class SubarrayExtents {
//
//    public static int[] findSubarrayExtents(int rows, int cols, int[] flattenedArray) {
//        int startRow = Integer.MAX_VALUE;
//        int startCol = Integer.MAX_VALUE;
//        int endRow = 0;
//        int endCol = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (flattenedArray[i * cols + j] == 1) {
//                    startRow = Math.min(startRow, i);
//                    startCol = Math.min(startCol, j);
//                    endRow = Math.max(endRow, i);
//                    endCol = Math.max(endCol, j);
//                }
//            }
//        }
//
//        int numRows = endRow - startRow + 1;
//        int numCols = endCol - startCol + 1;
//
//        return new int[]{startRow, startCol, numRows, numCols};
//    }
//
//    public static void main(String[] args) {
//        int[] inputArray = {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] outputResult = findSubarrayExtents(inputArray[0], inputArray[1], Arrays.copyOfRange(inputArray, 2, inputArray.length));
//        System.out.println(Arrays.toString(outputResult));
//    }
//}

/*
Consider a boolean array A of size Rows x Cols. Most of the array consists only of zeros. But there is a subarray which is rectangular in shape where there are only 1s. Lets say the size of this sub-array that rows > Rows/4 and cols > Cols/4.
How do you find the extents 0of the subarray with just the 1s? Find a solution that optimises the execution time.

input format: 1-D integer array of size w x h + 2. The first two integers represent number of Rows and Columns of the array , followed by the rest of the array flattened out. Assume row-wise traversal.
output format: 1-D integer array with 4 elements - start row, start col, no of rows, no of cols.

example input: 9,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
output : 2,0,3,7
*/

public class SubarrayExtents {

    public static int[] findSubarrayExtents(int rows, int cols, int[] flattenedArray) {
        int startRow = -1, startCol = -1;
        int endRow = -1, endCol = -1;

        // Iterate through the flattened array
        for (int i = 0; i < flattenedArray.length; i++) {
            int currentRow = i / cols;
            int currentCol = i % cols;

            if (flattenedArray[i] == 1) {
                // Update subarray extents on encountering the first '1'
                if (startRow == -1) {
                    startRow = currentRow;
                    startCol = currentCol;
                }

                // Update end column on encountering '1'
                endCol = currentCol;

                // Update end row if a new row starts
                if (currentRow > endRow) {
                    endRow = currentRow;
                }
            }
        }

        // Calculate the number of rows and columns in the subarray
        int numRows = (startRow == -1) ? 0 : endRow - startRow + 1;
        int numCols = (startCol == -1) ? 0 : endCol - startCol + 1;

        return new int[]{startRow, startCol, numRows, numCols};
    }

    public static void main(String[] args) {
        // Example usage
        int[] inputArray = {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] outputResult = findSubarrayExtents(inputArray[0], inputArray[1], Arrays.copyOfRange(inputArray, 2, inputArray.length));
        System.out.println(Arrays.toString(outputResult));
    }
}


