package Matrix;

import java.util.*;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 0, 1}
        };
        Map<Integer, List<Integer>> mn = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (mn.containsKey(i)) mn.get(i).add(j);
                    else {
                        int finalJ = j;
                        mn.put(i, new ArrayList<>(){{
                            add(finalJ);
                        }});
                    }
                }
            }
        }
        for (Integer i : mn.keySet()) {
            for (Integer j : mn.get(i)) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
                for (int l = 0; l < m; l++) {
                    matrix[l][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
