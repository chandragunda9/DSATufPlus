package sorting;

public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n - 2; i++) {
            int minInd = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[minInd]) {
                    minInd = j;
                }
            }
            int temp = nums[minInd];
            nums[minInd] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
