class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjajencyList = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            adjajencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
        adjajencyList.get(edge[0]).add(edge[1]);
        adjajencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : adjajencyList.get(node)) {
                if(parent.get(node) == neighbor) {
                    continue;
                }

                if(parent.containsKey(neighbor)) {
                    return false;
                }

                queue.offer(neighbor);
                parent.put(neighbor, node);

            }
        }


        return parent.size() == n;


        
    }
}