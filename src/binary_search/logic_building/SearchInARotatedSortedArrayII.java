package binary_search.logic_building;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SearchInARotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3;
        ArrayList<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(searchInARotatedSortedArrayII(al, target));
    }

    public static boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int low = 0, high = nums.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid).equals(k))
                return true;
            if (nums.get(low).equals(nums.get(mid)) && nums.get(mid).equals(nums.get(high))) {
                low++;
                high--;
                continue;
            }
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) <= k && k <= nums.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums.get(mid) <= k && k <= nums.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
