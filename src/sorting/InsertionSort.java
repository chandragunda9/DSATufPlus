package sorting;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[j];
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j = j - 1;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
