class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        
        while (start < end) {
            if (height[start] < height[end] ) {
                max = max > height[start]*(end-start) ? max : height[start]*(end-start);
                start++;
            } else {
                max = max > height[end]*(end-start) ? max : height[end]*(end-start);
                end--;
            }
        }
        return max;
    }
}