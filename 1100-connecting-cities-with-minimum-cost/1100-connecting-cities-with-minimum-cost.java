class DisjointSet {
    private int[] weights; // Used to store weights of each nodes 
    private int[] parents;

    public void Union(int a, int b) {
        int rootA = Find(a);
        int rootB = Find(b);
        
        if (rootA == rootB) return;


        if (this.weights[rootA] > this.weights[rootB]) {

            this.parents[rootB] = rootA;
            this.weights[rootA] += this.weights[rootB];
        } else {

            this.parents[rootA] = rootB;
            this.weights[rootB] += this.weights[rootA];
        }
    }

    public int Find(int a) {
        while (a != this.parents[a]) {
    
            this.parents[a] = this.parents[parents[a]];
            a = this.parents[a];
        }
        return a;
    }

    public boolean isInSameGroup(int a, int b) {

        return Find(a) == Find(b);
    }


    public DisjointSet(int N) {
        this.parents = new int[N + 1];
        this.weights = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            this.parents[i] = i;
            this.weights[i] = 1;
        }
    }
}

class Solution {
    public int minimumCost(int N, int[][] connections) {

        DisjointSet disjointset = new DisjointSet(N);     
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
       
        int total = 0;
        int cost = 0;

        for (int i = 0; i < connections.length; ++i) {

            int a = connections[i][0];
            int b = connections[i][1];

            if (disjointset.isInSameGroup(a, b)) continue;

            disjointset.Union(a, b);
            
            cost += connections[i][2];
            total++;
        }

        if (total == N - 1) {
            return cost;
        } else {
            return -1;
        }
    }
}