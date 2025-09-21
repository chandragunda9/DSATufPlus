package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 8, 10, 3, 2, 1};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    public static int[] selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minInd]) {
                    minInd = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minInd];
            nums[minInd] = temp;
        }
        return nums;
    }
}
