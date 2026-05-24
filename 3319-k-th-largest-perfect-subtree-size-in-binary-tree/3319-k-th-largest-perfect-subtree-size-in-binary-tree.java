import java.util.*;

class SubTree {
    int size;
    int levelOfLeaf; 

    SubTree(int size, int levelOfLeaf) {
        this.size = size;
        this.levelOfLeaf = levelOfLeaf;
    }
}

class Solution {
    List<Integer> largest = new ArrayList<>();

    public SubTree dfs(TreeNode root) {
        if (root == null) {
            return new SubTree(0, 0); 
        }

        SubTree leftSubTree = dfs(root.left);
        SubTree rightSubTree = dfs(root.right);

        if (leftSubTree.levelOfLeaf != -1 && 
            rightSubTree.levelOfLeaf != -1 && 
            leftSubTree.levelOfLeaf == rightSubTree.levelOfLeaf) {
            
            int currSize = leftSubTree.size + rightSubTree.size + 1;
            largest.add(currSize);
            
            // The leaf level relative to this node grows by 1
            return new SubTree(currSize, leftSubTree.levelOfLeaf + 1);
        }

        // If it's not perfect, return -1 for the leaf level to flag it to parent nodes
        return new SubTree(0, -1);
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
       
        dfs(root);

        // Sort in descending order to get largest elements first
        Collections.sort(largest, Collections.reverseOrder());

        // Check if we actually found at least k perfect subtrees
        if (largest.size() < k) {
            return -1;
        }

        // k-th largest is at index k-1 due to 0-based indexing
        return largest.get(k - 1);
    }
}