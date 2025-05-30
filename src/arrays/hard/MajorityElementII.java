package arrays.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 2};
        System.out.println(majorityElementTwo(arr));
    }

    public static List<Integer> majorityElementTwo(int[] nums) {
        int count1 = 0, count2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2++;
            } else if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                count1++;
            }
        }
        if (count1 > nums.length / 3) {
            ans.add(ele1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele2) {
                count2++;
            }
        }
        if (count2 > nums.length / 3) {
            ans.add(ele2);
        }
        Collections.sort(ans);
        return ans;
    }
}
