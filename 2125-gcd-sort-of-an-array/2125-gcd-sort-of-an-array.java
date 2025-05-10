class Solution {
  public boolean gcdSort(int[] nums) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }

    UnionFind uf = new UnionFind(max + 1);

	// avoid duplicated number
    boolean[] seen = new boolean[max + 1];

    // union all divisor
    for (int num : nums) {

      if (!seen[num]) {
        seen[num] = true;
        for (int p = 2; p * p <= num; p++) {
          if (num % p == 0) {
            uf.union(num, p);
            uf.union(num, num / p);
          }
        }
      }
      
    }

    int[] clone = nums.clone();
    Arrays.sort(clone);
    for (int i = 0; i < nums.length; i++) {
      if (!uf.find(nums[i], clone[i])) {
        return false;
      }
    }

    return true;
  }

  static class UnionFind {
    // parent of node
    private final int[] parent;
    // rank of disjoint set
    private final int[] rank;
    // number of disjoint set
    private int count;

    UnionFind(int n) {
      count = n;
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        // every node is itself
        parent[i] = i;
        // every node init rank is one
        rank[i] = 1;
      }
    }

    private int root(int p) {
      while (parent[p] != p) {
        // compress path
        parent[p] = parent[parent[p]];
        p = parent[p];
      }

      return p;
    }

    public int count() {
      return count;
    }

    public boolean find(int p, int q) {
      return root(p) == root(q);
    }

    public boolean union(int p, int q) {
      int rootP = root(p);
      int rootQ = root(q);
      if (rootP == rootQ) {
        return false;
      }

      if (rank[rootP] < rank[rootQ]) {
        parent[rootP] = rootQ;
        rank[rootQ] += rank[rootP];
      } else {
        parent[rootQ] = rootP;
        rank[rootP] += rank[rootQ];
      }

      count--;

      return true;
    }
  }
}