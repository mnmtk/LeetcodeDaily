class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < buildings.length; ++i){
            edges.add(Arrays.asList(buildings[i][0], buildings[i][2]));
            edges.add(Arrays.asList(buildings[i][1], -buildings[i][2]));
        }
        Collections.sort(edges, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        
        Queue<Integer> live = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        Queue<Integer> past = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        List<List<Integer>> answer = new ArrayList<>();
        
        
        int idx = 0;

        while (idx < edges.size()){

            int currX = edges.get(idx).get(0);
            
            while (idx < edges.size() && edges.get(idx).get(0) == currX){
               
                int height = edges.get(idx).get(1);
                
                if (height > 0){
                    live.offer(height);
                } else {
                    past.offer(-height);
                }
                idx++;
            }

            while (!past.isEmpty() && live.peek().equals(past.peek())) {
                live.remove();
                past.remove();
            }
            

            int currHeight = live.isEmpty() ? 0 : live.peek();

            if (answer.isEmpty() || answer.get(answer.size() - 1).get(1) != currHeight) {
                answer.add(Arrays.asList(currX, currHeight));
            }   
        }
            
        return answer;
    }
}