/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
 public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
	//inorder to get two sorted list
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

		//merge two sorted list
        List<Integer> ans = new ArrayList<>();
        while(list1.size() > 0 || list2.size() > 0) {
            int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
            if(list1.size() > 0) val1 = list1.get(0);
            if(list2.size() > 0) val2 = list2.get(0);
            if(val1 < val2) {
                ans.add(val1);
                list1.remove(0);
            } else {
                ans.add(val2);
                list2.remove(0);
            }
        }

        return ans;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}