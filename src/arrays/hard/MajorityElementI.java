package arrays.hard;

public class MajorityElementI {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int count = 0, ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
                count = 1;
            } else if (nums[i] == ans) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}
