package sorting;

public class BubbleSort {

    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            boolean anySwaps = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    anySwaps = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!anySwaps) {
                return nums;
            }
        }
        return nums;
    }

}
