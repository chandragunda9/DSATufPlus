package arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;

        List<Integer> res = new ArrayList<>();
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (res.isEmpty() || !res.get(res.size() - 1).equals(nums1[i])) {
                    res.add(nums1[i]);
                }
                i++;
            } else {
                if (res.isEmpty() || !res.get(res.size() - 1).equals(nums2[j])) {
                    res.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (!res.get(res.size() - 1).equals(nums1[i])) {
                res.add(nums1[i]);
            }
            i++;
        }

        while (j < m) {
            if (!res.get(res.size() - 1).equals(nums2[j])) {
                res.add(nums2[j]);
            }
            j++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
