package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={7, 4, 1, 5, 3};
        System.out.println(Arrays.toString(quickSort(arr)));
    }
    public static int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    static int partition(int[] nums, int low, int high) {
        int l = low, r = high;
        while (l < r) {
            while (l <= high && nums[l] <= nums[low]) {
                l++;
            }
            while (r >= low && nums[r] > nums[low]) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        int temp = nums[r];
        nums[r] = nums[low];
        nums[low] = temp;
        return r;
    }

    static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            sort(nums, low, p - 1);
            sort(nums, p + 1, high);
        }
    }
}
