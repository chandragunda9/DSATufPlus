package arrays.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        //transposing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reversing each array
        for (int i = 0; i < n; i++) {
            int finalI = i;
            int[] array = IntStream.range(0, n).map(j -> matrix[finalI][n - j - 1]).toArray();
            matrix[i] = array;
        }
    }
}
