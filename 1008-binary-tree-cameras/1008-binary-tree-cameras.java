class Solution {
  int ans = 0;
  
  int DFS(TreeNode node){
    if(node != null){
      int l = DFS(node.left);
      int r = DFS(node.right);
      
      if(l == 1 && r == 1) return 0;
      if(l == 0 || r == 0) {ans++; return 2;}
    }
    return 1;
  }
  
  int minCameraCover(TreeNode root) {
    if(DFS(root) == 0) ans++;
    return ans;
  }
}