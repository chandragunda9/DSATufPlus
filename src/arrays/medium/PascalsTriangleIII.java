package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIII {

    public List<List<Integer>> pascalTriangleIII(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(getNthRow(i));
        }
        return ans;
    }

    List<Integer> getNthRow(int row) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int mul = 1;
        for (int i = 1; i < row; i++) {
            mul = mul * (row - i) / i;
            ans.add(mul);
        }
        return ans;
    }
}
