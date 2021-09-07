package misc;

public class TrapRainWater {
    public static int trap(int[] height) {
        int n = height.length - 1;


        int maxLeft = height[0];
        int maxRight = height[n];
        int trappedWater = 0;
        int left = 1;
        int right = n - 1;

        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    trappedWater += maxLeft - height[left];
                left++;
            } else {
                if (height[right] >= maxLeft)
                    maxRight = height[right];
                else
                    trappedWater += maxRight - height[right];
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trap(height);
    }
}
