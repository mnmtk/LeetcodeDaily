// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {

//             if (map.containsKey(nums[i])) {
//                 return true;
//             }

//             map.put(nums[i],1);
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums); 

//         for (int i = 0; i < nums.length - 1; i++) {
//                 if (nums[i] == nums[i+1]) {
//                     return true;
//                 }
//         }
//         return false;
//     }
    
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i])
                return true;
            else if (nums[i] < nums[i - 1]){
                int temp = nums[i - 1];
                for(int j = i - 2; j >= 0; j--){
                    if(nums[i] == nums[j])
                        return true;
                }
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return false;
    }
}