package arrays.medium;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeadersInArray {
    public ArrayList<Integer> leaders(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        return IntStream.range(0, ans.size()).mapToObj(i -> ans.get(ans.size() - i - 1))
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
