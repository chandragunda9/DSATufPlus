package arrays.hard;

import java.util.Arrays;

public class RepeatingAndMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 7, 5, 7};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }

    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }

//        int pos = 0;
//        while (true) {
//            if ((xor & (1 << pos)) != 0) {
//                break;
//            }
//            pos++;
//        }
        int num = xor & ~(xor - 1);

        int ones = 0, zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
//            if ((nums[i] & (1 << pos)) != 0) {
            if ((nums[i] & num) != 0) {
                ones ^= nums[i];
            } else {
                zeroes ^= nums[i];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if ((i & num) != 0) {
                ones ^= i;
            } else {
                zeroes ^= i;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ones) {
                count++;
            }
        }
        return count >= 2 ? new int[]{ones, zeroes} : new int[]{zeroes, ones};
    }
}
