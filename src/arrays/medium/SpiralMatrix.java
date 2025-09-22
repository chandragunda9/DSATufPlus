package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m - 1, top = 0, down = n - 1;
        int dir = 0;
        List<Integer> ans = new ArrayList<>();
        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int j = left; j <= right; j++) {
                    ans.add(matrix[top][j]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[down][j]);
                }
                down--;
            } else {
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }
}
