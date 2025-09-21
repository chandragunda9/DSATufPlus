package arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0}, nums2 = {-3, 1, 8};
        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = m - 1, left = 0;
        while (right >= 0 && left < n) {
            if (nums1[right] > nums2[left]) {
                int temp = nums1[right];
                nums1[right] = nums2[left];
                nums2[left] = temp;
                right--;
                left++;
            } else
                break;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
    }
}
