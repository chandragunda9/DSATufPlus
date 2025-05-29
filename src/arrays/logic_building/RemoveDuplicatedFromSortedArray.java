package arrays.logic_building;

public class RemoveDuplicatedFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 3, 5, 6};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
