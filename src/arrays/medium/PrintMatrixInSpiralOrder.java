package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralOrder {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder1(mat));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        int n = matrix.length, m = matrix[0].length, left = 0, right = m - 1, top = 0, down = n - 1;
        List<Integer> res = new ArrayList<>();

        while (left <= right && top <= down) {
            if (dir == 0) {
                for (int j = left; j <= right; j++) {
                    res.add(matrix[top][j]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
                down--;

            } else {
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();

        while (top <= down && left <= right) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= down) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
