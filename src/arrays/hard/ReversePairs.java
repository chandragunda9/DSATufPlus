package arrays.hard;

public class ReversePairs {

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 3, 3};
        System.out.println(reversePairs(arr));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }

    static int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += reversePairsCount(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return count;
    }

    static int reversePairsCount(int[] nums, int low, int mid, int high) {
        int count = 0, right = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right <= high && nums[left] > 2 * nums[right]) {
                right++;
            }
            count += (right - mid - 1);
        }
        return count;
    }
}
