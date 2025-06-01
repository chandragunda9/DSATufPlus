package arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2 = {-3, 1, 8};
//        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        merge1(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = 0;
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else
                break;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    static void swapIfGreater(int[] nums1, int[] nums2, int i, int j) {
        if (nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }

    //By using Gap method
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n, gap = len / 2 + len % 2;
        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < len) {
                //if both in left array
                if (right < m) {
                    swapIfGreater(nums1, nums1, left, right);
                }
                //if both in right array
                else if (left >= m) {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }
                //if each in each array
                else {
                    swapIfGreater(nums1, nums2, left, right - m);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = gap / 2 + gap % 2;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}
