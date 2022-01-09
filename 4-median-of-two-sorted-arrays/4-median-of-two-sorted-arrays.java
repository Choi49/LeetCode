class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] merged = new int[nums1.length+nums2.length];
        while (i<nums1.length && j <nums2.length) {
            // if (nums1[i] > nums2[j]) {
            //     merged[i+j] = nums1[i++];
            // } else {
            //     merged[i+j] = nums2[j++];
            // }
            merged[i+j] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i+j <= (merged.length)/2 ) {
            if (i < nums1.length ) {
                merged[i+j] = nums1[i++];
            } else {
                merged[i+j] = nums2[j++];
            }
        }
        
        if (merged.length%2 == 0) {
            return (double)(merged[merged.length/2] + merged[merged.length/2-1])/2;
        }
        return merged[merged.length/2];
    }
}