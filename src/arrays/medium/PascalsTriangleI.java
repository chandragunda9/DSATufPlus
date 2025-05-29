package arrays.medium;

public class PascalsTriangleI {
    public int pascalTriangleI(int row, int col) {
        return nCr(row - 1, col - 1);
    }

    int nCr(int n, int r) {
        if (n - r < r) {
            r = n - r;
        }
        int mul = 1;
        for (int i = 0; i < r; i++) {
            mul = mul * (n - i) / (i + 1);
        }
        return mul;
    }
}
