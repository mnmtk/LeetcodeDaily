class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {

        int n = nums.length; //nodes in my topo sort;
        int[] inDegree = new int[n + 1];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(List<Integer> seq : sequences) {
            for(int index = 1; index < seq.size(); index++) {
                int nodeA = seq.get(index - 1);
                int nodeB = seq.get(index);

                if(nodeA < 1 || nodeA > n || nodeB < 1 || nodeB > n) return false;

                graph.computeIfAbsent(nodeA, k -> new ArrayList<>()).add(nodeB);
                inDegree[nodeB]++;
            }
        }

        Queue<Integer> topoSort = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                topoSort.offer(i);
            }
        }

        int i = 0;
        while(!topoSort.isEmpty()) {
        
            if(topoSort.size() > 1 || topoSort.peek() != nums[i]) {
                return false;
            };

            int current = topoSort.poll();

            for(Integer next : graph.getOrDefault(current, new ArrayList<>())) {
                inDegree[next]--;
                if(inDegree[next] == 0) topoSort.offer(next);
            }
            i++;

        }


        return true;


        
    }
}