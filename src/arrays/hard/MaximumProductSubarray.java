package arrays.hard;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 7, 1, 2};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int pre = 1, suf = 1, n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pre = pre * nums[i];
            suf = suf * nums[n - i - 1];
            maxProd = Math.max(maxProd, Math.max(pre, suf));
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;
        }
        return maxProd;
    }
}
