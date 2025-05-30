package arrays.medium;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, -7, -2, -10, -4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray1(arr));
        System.out.println(maxSubArray2(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int l = 0, ansStart = -1, ansEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                l = i;
            }
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = l;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i]);
        }
        return maxSum;
    }

    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
