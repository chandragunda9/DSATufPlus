package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                res[neg] = nums[i];
                neg += 2;
            } else {
                res[pos] = nums[i];
                pos += 2;
            }
        }
        return res;
    }
}
