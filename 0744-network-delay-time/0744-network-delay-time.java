class Solution {
    Map<Integer, List<int[]>> map = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {

        buildGraph(times);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] shortest = new int[n + 1];
        Arrays.fill(shortest, -1);

        pq.offer(new int[] { k, 0 });

        System.out.println(n + "n");
        System.out.println(k + "k");

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if (shortest[node] != -1) continue;
            shortest[node] = time;

            if(map.getOrDefault(node, new ArrayList<>()).size() < 1) continue;
            

            for (int[] next : map.getOrDefault(node, new ArrayList<>())) {
               
                pq.offer(new int[] { next[0], next[1] + time });
            }

        }

        int ans = shortest[1];
        boolean no = false;

        for (int i = 1; i <= n; i++) {
            System.out.print(" each" + shortest[i]);
            ans = Math.max(shortest[i], ans);
            if(shortest[i] == -1) no = true; 
        }

        if (no) return -1;

        return ans == 0 ? -1: ans == -1 ? -1 : ans;
    }

    public void buildGraph(int[][] times) {

        for (int[] time : times) {

            map.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new int[] { time[1], time[2] });

            
        }

    }
}