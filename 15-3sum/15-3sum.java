import java.util.Arrays;

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         if(nums.length < 3){
//             return new ArrayList<>();
//         }
//         Arrays.sort(nums);
//         int max = nums[nums.length-1];
//         List<List<Integer>> result = new ArrayList<>();
//         for (int i =0; i<nums.length-2; i++) {
//             for (int j=i+1; j<nums.length-1; j++) {
//                 if (nums[i]+nums[j] > nums[j]) {
//                     break;
//                 } 
//                 for (int k = j+1; k<nums.length; k++) {
//                     if (nums[i] + nums[j] + nums[k]==0) {
//                         List triplet = List.of(nums[i],nums[j],nums[k]);
//                         boolean check = true;
//                         for (List l : result){
//                             if (Arrays.equals(l.toArray(), triplet.toArray())) {
//                                 check = false;
//                                 break;
//                             }
//                         }
//                         if (check) {
//                             result.add(List.of(nums[i],nums[j],nums[k]));
//                         }
//                     }
//                 }
//             }
//         }
//         return result;
//     }
// }



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
                    while (j < k && tmp == nums[j] ){
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    int tmp = nums[j];
                    while (j < k && tmp == nums[j] ){
                        j++;
                    }
                }
            }
        }
        
        return result;
    }
}