package arrays.hard;

import java.util.Arrays;

public class MissingAndRepeatingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }

    public static int[] findMissingRepeatingNumbers1(int[] nums) {
        long s = 0, s2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            s2 += (long) nums[i] * (long) nums[i];
        }
        long sn = (long) n * (n + 1) / 2;
        long s2n = (n * (n + 1) * (2L * n + 1)) / 6;
        long val1 = s - sn;
        long val2 = s2 - s2n;

        val2 = val2 / val1;

        int x = (int) ((val1 + val2) / 2);
        int y = (int) (x - val1);
        return new int[]{x, y};
    }

    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            xor ^= i;
        }
//        int bitPos = 0;
//        while (true) {
//            if ((xor & (1 << bitPos)) != 0) {
//                break;
//            }
//            bitPos++;
//        }
        int numValue = xor & -xor;
        int ones = 0, zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
//            if ((nums[i] & (1 << bitPos)) != 0) {
            if ((nums[i] & numValue) != 0) {
                ones ^= nums[i];
            } else {
                zeroes ^= nums[i];
            }
        }
        for (int num = 1; num <= nums.length; num++) {
//            if ((num & (1 << bitPos)) != 0) {
            if ((num & numValue) != 0) {
                ones ^= num;
            } else {
                zeroes ^= num;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ones) count++;
        }
        return (count >= 2) ? new int[]{ones, zeroes} : new int[]{zeroes, ones};
    }
}
