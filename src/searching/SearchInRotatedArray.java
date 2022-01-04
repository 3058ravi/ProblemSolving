package searching;

public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, pivot = 0;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[right])
                left = pivot + 1;
            else
                right = pivot;
        }


        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            else if (nums[pivot] < target)
                left = pivot + 1;
            else
                right = pivot - 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5};
       System.out.println( search(arr, 5));
    }
}
