class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        
        while (start < end) {
            if (height[start] < height[end] ) {
                max = max > height[start]*(end-start) ? max : height[start]*(end-start);
                int tmp = height[start];
                while (start < end && height[start] <= tmp) {
                    start++;
                }
            } else {
                max = max > height[end]*(end-start) ? max : height[end]*(end-start);
                int tmp = height[end];
                while (start < end && height[end] <= tmp) {
                    end--;
                }
            }
        }
        return max;
    }
}