package arrays.hard;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(arr));
    }

    public static long numberOfInversions(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    static long merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        long count = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += (mid - i + 1);
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
        return count;
    }

    static long sort(int[] nums, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += sort(nums, left, mid);
            count += sort(nums, mid + 1, right);
            count += merge(nums, left, mid, right);
        }
        return count;
    }
}
