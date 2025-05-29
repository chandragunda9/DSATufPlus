package sorting;

public class BubbleSort {
    public static void main(String[] args) {

    }

    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            int didSwap = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    didSwap = 1;
                }
            }
            if (didSwap == 0)
                break;
        }
        return nums;
    }
}
