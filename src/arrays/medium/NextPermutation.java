package arrays.medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int breakpoint = -1, n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        if (breakpoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > breakpoint; i--) {
            if (nums[i] > nums[breakpoint]) {
                swap(nums, breakpoint, i);
                break;
            }
        }

        reverse(nums, breakpoint + 1, n - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
