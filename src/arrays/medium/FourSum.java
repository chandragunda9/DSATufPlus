package arrays.medium;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, 7, 9};
        int target = 7;
        System.out.println(fourSum(arr, target));
        System.out.println(fourSum1(arr, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int l = n - 1; l >= 3; l--) {
            if (l != n - 1 && nums[l] == nums[l + 1])
                continue;

            for (int k = l - 1; k >= 2; k--) {
                if (k != l - 1 && nums[k] == nums[k + 1])
                    continue;

                int i = 0, j = k - 1;
                while (i < j) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(nums[l]);
                        ans.add(li);
                        while (i < j && nums[i] == nums[i + 1])
                            i++;
                        while (i < j && nums[j] == nums[j - 1])
                            j--;
                        i++;
                        j--;

                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> quadraSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> hashSet = new HashSet<>();

                for (int k = j + 1; k < n; k++) {
                    int fourth = target - (nums[i] + nums[j] + nums[k]);
                    if (hashSet.contains(fourth)) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(fourth);
                        Collections.sort(li);
                        quadraSet.add(li);
                    }
                    hashSet.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(quadraSet);
    }
}
