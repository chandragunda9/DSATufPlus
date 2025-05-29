package sorting;

public class QuickSort {

    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pIndex = partition(nums, low, high);
            sort(nums, low, pIndex - 1);
            sort(nums, pIndex + 1, high);
        }
    }

    int partition(int[] nums, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (i <= high && nums[i] <= nums[low]) {
                i++;
            }
            while (j >= low && nums[j] > nums[low]) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }
}
