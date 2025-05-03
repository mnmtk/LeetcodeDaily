class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int maxHeight = -1;

    private int getHeight(TreeNode root) {
        if (root == null) return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int height = Math.max(left, right) + 1;

        map.computeIfAbsent(height, k -> new ArrayList<>()).add(root.val);

        maxHeight = Math.max(maxHeight, height);
        
        return height;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= maxHeight; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
