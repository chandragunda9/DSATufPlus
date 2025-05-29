package arrays.logic_building;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        return xor;
    }

    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int sumN = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sumN - sum;
    }
}
