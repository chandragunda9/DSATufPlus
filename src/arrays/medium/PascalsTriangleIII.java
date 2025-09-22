package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIII {
    public List<List<Integer>> pascalTriangleIII(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(nthRow(i));
        }
        return ans;
    }

    List<Integer> nthRow(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int mul = 1;
        for (int i = 1; i < n; i++) {
            mul = mul * (n - i) / i;
            ans.add(mul);
        }
        return ans;
    }
}
