import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Long, Integer> prefixMap = new HashMap<>();
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {

        prefixMap.put(0L, 1);
        pathSumHelper(root, 0L, targetSum);
        return ans;
    }

    public void pathSumHelper(TreeNode root, long runningSum, int targetSum) {
        if (root == null) return;

    
        runningSum += root.val;

       
        ans += prefixMap.getOrDefault(runningSum - targetSum, 0);

        prefixMap.put(runningSum, prefixMap.getOrDefault(runningSum, 0) + 1);

 
        pathSumHelper(root.left, runningSum, targetSum);
        pathSumHelper(root.right, runningSum, targetSum);

        // IMPORTNT
        // BACKTRACK: Remove the current running sum so it doesn't affect other branches
        prefixMap.put(runningSum, prefixMap.get(runningSum) - 1);
    }
}