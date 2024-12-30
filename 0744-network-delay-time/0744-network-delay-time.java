class Solution {
    //AdjajencyList
   Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();



    public void BFS(int[] signalRecievedAt, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);

        signalRecievedAt[sourceNode] = 0;

        while(!queue.isEmpty()) {
            int currNode = queue.remove();

            if(!adj.containsKey(currNode)) {
                continue;
            }

            //In the adjacency list representation, if currNode is not a key in the adj map, it means that there are no outgoing edges from currNode.
            //For such nodes, there's no need to broadcast the signal further because there are no neighboring nodes to proces.
           for(Pair<Integer, Integer> edge : adj.get(currNode)) {
            int time = edge.getKey();
            int neighborNode = edge.getValue();

            int arrivalTime = signalRecievedAt[currNode] + time;
            if(signalRecievedAt[neighborNode] > arrivalTime) {
                signalRecievedAt[neighborNode] = arrivalTime;
                queue.add(neighborNode);
            }
           }
        }

    }


    public int networkDelayTime(int[][] times, int n, int k) {

        for (int[] time : times) {
            int source = time[0];
            int des = time[1];
            int time1 = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(time1, des));
        }

        int[] signalRecievedAt = new int[n+1];
        Arrays.fill(signalRecievedAt, Integer.MAX_VALUE);

        BFS(signalRecievedAt, k);

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalRecievedAt[i]);
        }


        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}