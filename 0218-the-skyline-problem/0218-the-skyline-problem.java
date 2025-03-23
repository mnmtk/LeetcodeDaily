class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Iterate over all buildings, for each building i
        // add (position, i) to edges.
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < buildings.length; ++i){
            edges.add(Arrays.asList(buildings[i][0], i));
            edges.add(Arrays.asList(buildings[i][1], i));
        }
        Collections.sort(edges, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        
        // Initailize an empty Priority Queue 'live' to store all the newly 
        // added buildings, an empty list answer to store the skyline key points.
        Queue<List<Integer>> live = new PriorityQueue<>((a, b) -> {
            return b.get(0) - a.get(0);
        });
        List<List<Integer>> answer = new ArrayList<>();
        
        int idx = 0;
        
      
        while (idx < edges.size()){
            
            int currX = edges.get(idx).get(0);
            
          
            while (idx < edges.size() && edges.get(idx).get(0) == currX){

                int b = edges.get(idx).get(1);
               
                if (buildings[b][0] == currX){
                    int right = buildings[b][1];
                    int height = buildings[b][2];
                    live.offer(Arrays.asList(height, right));
                }
                idx += 1;
            }
            
      
            while (!live.isEmpty() && live.peek().get(1) <= currX)
                live.poll();
            
           
            int currHeight = live.isEmpty() ? 0 : live.peek().get(0);
            
            
            if (answer.isEmpty() || answer.get(answer.size() - 1).get(1) != currHeight)
                answer.add(Arrays.asList(currX, currHeight));
        }
        
        return answer;
    }
}