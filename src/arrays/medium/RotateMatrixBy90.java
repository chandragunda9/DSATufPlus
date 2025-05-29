package arrays.medium;

public class RotateMatrixBy90 {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        //Transposing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reversing each array
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
