package arrays.hard;

public class CountInversions {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(nums));
    }

    public static long numberOfInversions(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    static long sort(int[] nums, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += sort(nums, low, mid);
            count += sort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }

    static long merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        long count = 0;
        int left = low, right = mid + 1, k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
                count += (mid - left + 1);
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
        return count;
    }
}
