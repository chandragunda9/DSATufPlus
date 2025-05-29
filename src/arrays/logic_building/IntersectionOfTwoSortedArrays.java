package arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        List<Integer> res = new ArrayList<>();
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
