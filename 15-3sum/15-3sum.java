import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        for (int i =0; i<nums.length-2;i++){
            if(nums[i] == prev){
                continue;
            }
            prev = nums[i];
            int j = i+1;
            int k = nums.length-1;
            
            while (k > j && nums[i] + nums[j] <= 0) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(List.of(nums[i],nums[j],nums[k]));
                    int tmp = nums[j];
                    while (j < k && tmp == nums[j] ) j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    int tmp = nums[k];
                    while (j < k && tmp == nums[k] ) k--;
                } else {
                    int tmp = nums[j];
                    while (j < k && tmp == nums[j] ) j++;
                }
            }
        }
        
        return result;
    }
}