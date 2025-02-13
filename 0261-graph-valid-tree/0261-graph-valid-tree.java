class Solution {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            int node = queue.remove();
            if(set.contains(node)) return false;

            for(int node2 : map.get(node)) {
                // we should remove the edge: node -> top
                queue.add(node2);
                map.get(node2).remove(node);
            }

            set.add(node);
        }
     return set.size() == n;   
    }
}