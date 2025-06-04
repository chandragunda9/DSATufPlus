package binary_search.logic_building;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 10, 1, 2, 3};
        ArrayList<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(findMin(al));
        System.out.println(findMin1(al, 0, al.size() - 1));
    }

    public static int findMin(ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(low) <= arr.get(mid)) {
                ans = Math.min(ans, arr.get(low));
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr.get(mid));
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findMin1(ArrayList<Integer> arr, int low, int high) {
        if (low > high)
            return Integer.MAX_VALUE;
        int mid = (low + high) / 2;
        if (arr.get(low) <= arr.get(mid))
            return Math.min(arr.get(low), findMin1(arr, mid + 1, high));
        return Math.min(arr.get(mid), findMin1(arr, low, mid - 1));
    }
}
