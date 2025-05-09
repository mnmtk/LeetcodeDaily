class UnionFind {
    private final int n;
    private final int[] parents;
    private final int[] size;
    public int components;

    UnionFind(int n) {
        this.n = n;
        parents = new int[n];
        size = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

   //// IMPORTAAANTEEEE
    public boolean union(int parent, int child) {
        int parentParent = find(parent);
        int childParent = find(child);

        if (childParent != child || parentParent == childParent) {
            return false;
        }

        components--;

        parents[childParent] = parentParent;
        size[parentParent] += size[childParent];

        return true;
    }

    private int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }
}

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int node = 0; node < n; node++) {
            int[] children = { leftChild[node], rightChild[node] };
            for (int child : children) {
                if (child == -1) {
                    continue;
                }

                if (!uf.union(node, child)) {
                    return false;
                }
            }
        }

        return uf.components == 1;
    }
}