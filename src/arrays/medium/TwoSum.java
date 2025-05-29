package arrays.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 10, 3};
        int target = 7;
        System.out.println(Arrays.toString(twoSum1(arr, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sums.containsKey(target - nums[i])) {
                return new int[]{i, sums.get(target - nums[i])};
            } else {
                sums.put(nums[i], i);
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        int[][] elements = new int[n][2];

        for (int i = 0; i < n; i++) {
            elements[i] = new int[]{nums[i], i};
        }
        Arrays.sort(elements, Comparator.comparingInt(a -> a[0]));

        int[] ans = new int[2];
        int left = 0, right = n - 1;
        while (left < right) {
            if (elements[left][0] + elements[right][0] == target) {
                ans[0] = elements[left][1];
                ans[1] = elements[right][1];
                return ans;
            } else if (elements[left][0] + elements[right][0] < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
