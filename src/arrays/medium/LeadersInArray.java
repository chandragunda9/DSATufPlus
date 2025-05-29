package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 1, 2};
        System.out.println(leaders(arr));
    }

    public static ArrayList<Integer> leaders(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        reverse(ans);
        return new ArrayList<>(ans);
    }

    static void reverse(List<Integer> nums) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i++;
            j--;
        }
    }
}
