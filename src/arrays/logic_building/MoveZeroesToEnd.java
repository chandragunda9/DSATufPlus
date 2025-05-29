package arrays.logic_building;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 0, 5, 2};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, zeroPointer, nonZeroPointer;
        for (zeroPointer = 0; zeroPointer < n; zeroPointer++) {
            if (nums[zeroPointer] == 0)
                break;
        }

        for (nonZeroPointer = zeroPointer + 1; nonZeroPointer < n; nonZeroPointer++) {
            if (nums[nonZeroPointer] != 0) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = temp;
                zeroPointer++;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {

        int n = nums.length;
        int i = 0, j = 0;
        //put i at first zero element
        for (i = 0; i < n; i++) {
            if (nums[i] == 0)
                break;
        }

        //put j at first non-zero element
        for (j = i + 1; j < n; j++) {
            if (nums[j] != 0)
                break;
        }

        while (i < n && j < n) {
            if (nums[i] == 0 && nums[j] != 0) {
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[i] != 0) {
                i++;
            } else if (nums[j] == 0) {
                j++;
            }
        }
    }
}
