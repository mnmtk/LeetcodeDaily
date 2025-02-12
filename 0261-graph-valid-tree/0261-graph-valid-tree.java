class Solution {


    public class DisjointSetUnion {
        int[] parents;
        int[] size; 

        DisjointSetUnion(int n) {
            parents = new int[n];
            size = new int[n];

            for(int i = 0 ; i < n ; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if(parents[x] == x) return x;
            return parents[x] = find(parents[x]);
        }

        boolean union(int u, int v) {
            int u1 = find(u);
            int v1 = find(v);

            if(u1 == v1) {
                return false;
            }

            if(size[u1] >= size[v1]) {
                parents[v1] = u1;
                size[u1] += size[v1];

            } else {
                parents[u1] = v1;
                size[v1] += size[u1];
            }

            return true;

        }
    }

    public boolean validTree(int n, int[][] edges) {

        DisjointSetUnion dsu = new DisjointSetUnion(n);
        for(int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) return false;
        }
        
     
        int sim = dsu.parents[0];

        for(int i=0; i<n; i++) {
            dsu.find(i);
        }

        for(int each : dsu.parents) 
            System.out.println(each);

        for(int each : dsu.parents) {

            if (each != sim) return false;
        }

        return true;
    }
}