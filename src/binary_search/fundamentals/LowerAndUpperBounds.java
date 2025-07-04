package binary_search.fundamentals;

public class LowerAndUpperBounds {
    public int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
