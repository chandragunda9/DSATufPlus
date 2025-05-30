package arrays.medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {2, -2, 0, 3, -3, 5};
        System.out.println(threeSum(arr));
        System.out.println(threeSum1(arr));
        System.out.println(threeSum2(arr));
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

    public static List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        tripletSet.add(list);
                    }
                }
            }
        }
        return tripletSet.stream().toList();
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashSet.contains(third)) {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(third);
                    Collections.sort(li);
                    tripletSet.add(li);
                }
                hashSet.add(nums[j]);

            }
        }
        return new ArrayList<>(tripletSet);
    }
}
