package arrays.hard;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {6, 4, 1, 2, 7};
        ReversePairs rev = new ReversePairs();
        System.out.println(rev.reversePairs(arr));
    }

    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int l = low; l <= high; l++) {
            nums[l] = temp[l - low];
        }
    }

    int sort(int[] nums, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += sort(nums, left, mid);
            count += sort(nums, mid + 1, right);
            count += reversePairsCount(nums, left, mid, right);
            merge(nums, left, mid, right);
        }
        return count;
    }

    int reversePairsCount(int[] nums, int low, int mid, int high) {
        int right = mid + 1, count = 0;
        for (int left = low; left <= mid; left++) {
            while (right <= high && nums[left] > (long) 2 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
}
