class Solution {
    void getleaf(ArrayList<Integer> r,TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null){
            r.add(root.val);
            return;
        }
        getleaf(r,root.left);
        getleaf(r,root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        getleaf(r1,root1);
        getleaf(r2,root2);
        if(r1.size()!=r2.size()) return false;
        for(int i = 0 ; i <r1.size() ; i++){
            int a = r1.get(i),b=r2.get(i);
            if(a!=b) {
                return false;
            }
        }
        return true;
    }
}