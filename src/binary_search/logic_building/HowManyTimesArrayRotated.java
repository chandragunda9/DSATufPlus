package binary_search.logic_building;

import java.util.ArrayList;

public class HowManyTimesArrayRotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1, minEle = Integer.MAX_VALUE, ind = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < minEle) {
                    minEle = nums.get(low);
                    ind = low;
                    break;
                }
            }
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < minEle) {
                    minEle = nums.get(low);
                    ind = low;
                }
                low = mid + 1;
            } else {
                if (nums.get(mid) < minEle) {
                    minEle = nums.get(mid);
                    ind = mid;
                }
                high = mid - 1;
            }
        }
        return ind;
    }
}
