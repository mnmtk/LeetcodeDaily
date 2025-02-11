class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        SortedSet<Integer> edgeSet = new TreeSet<Integer>();
        for(int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            edgeSet.add(left);
            edgeSet.add(right);
        }

        List<Integer> edges = new ArrayList<Integer>(edgeSet);
        Map<Integer, Integer> edgeIndexMap = new HashMap<>();
        for(int i =0; i < edges.size(); ++i) {
            edgeIndexMap.put(edges.get(i), i);
        }

        int[] heights = new int[edges.size()];

        for(int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            int leftIndex = edgeIndexMap.get(left);
            int rightIndex = edgeIndexMap.get(right);

            for(int idx = leftIndex; idx < rightIndex; ++idx){
                heights[idx] = Math.max(heights[idx], height);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0 ; i < heights.length; ++i) {
            int currHeight = heights[i];
            int currPos = edges.get(i);

            if(answer.isEmpty() || answer.get(answer.size() - 1).get(1) != currHeight) {
                answer.add(Arrays.asList(currPos, currHeight));
            }
        }

        return answer;
        
    }
}