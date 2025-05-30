package arrays.hard;

public class MajorityElementI {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int count = 0, ele = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ele = nums[i];
                count++;
            } else if (ele == nums[i])
                count += 1;
            else
                count -= 1;
        }
        return ele;
    }
}
