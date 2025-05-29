package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {2, -2, 0, 3, -3, 5};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = n - 1; k >= 2; k--) {
            if (k == n - 1 || nums[k] != nums[k + 1]) {
                int i = 0, j = k - 1;
                while (i < j) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> li = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        ans.add(li);
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return ans;
    }
}
