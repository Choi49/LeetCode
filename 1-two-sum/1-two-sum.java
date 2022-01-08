// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for (int i=0;i<nums.length;i++){
//             for (int j=i+1;j<nums.length;j++){
//                 if (nums[i]+nums[j]==target) {
//                     return new int[] {i,j};
//                 }
//             }
//         }
//         return new int[] {0,0};
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer> (); 
        for (int i=0;i<nums.length;i++){
            int counterpart = target - nums[i];
            if (map.containsKey(counterpart)) {
                return new int[] {map.get(counterpart),i};
            }
            map.put(nums[i], i);
        }
        return new int[] {0,0};
    }
}