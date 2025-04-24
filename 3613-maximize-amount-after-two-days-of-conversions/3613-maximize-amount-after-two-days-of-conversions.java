import java.util.*;

class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, List<Pair>> m1 = fun1(pairs1, rates1);
        Map<String, List<Pair>> m2 = fun1(pairs2, rates2);

        Map<String, Double> count = new HashMap<>();
        count.put(initialCurrency, 1.0);

        fun2BFS(m1, count);
        fun2BFS(m2, count);

        return count.getOrDefault(initialCurrency, 0.0);
    }

    private Map<String, List<Pair>> fun1(List<List<String>> mp, double[] flag) {
        Map<String, List<Pair>> m1 = new HashMap<>();
        for (int i = 0; i < mp.size(); i++) {
            String s = mp.get(i).get(0);
            String s1 = mp.get(i).get(1);
            double r = flag[i];

            m1.computeIfAbsent(s, k -> new ArrayList<>()).add(new Pair(s1, r));
            m1.computeIfAbsent(s1, k -> new ArrayList<>()).add(new Pair(s, 1.0 / r));
        }
        return m1;
    }

    // BFS-based relaxation method replacing fun2
    private void fun2BFS(Map<String, List<Pair>> graph, Map<String, Double> count) {
        Queue<String> queue = new LinkedList<>();
        Set<String> inQueue = new HashSet<>();

        // Initialize queue with all currencies currently in count
        for (String currency : count.keySet()) {
            queue.offer(currency);
            inQueue.add(currency);
        }

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            inQueue.remove(curr);
            double currAmount = count.getOrDefault(curr, 0.0);

            for (Pair neighbor : graph.getOrDefault(curr, Collections.emptyList())) {
                double newAmount = currAmount * neighbor.r;
                if (newAmount > count.getOrDefault(neighbor.curr, 0.0)) {
                    count.put(neighbor.curr, newAmount);
                    if (!inQueue.contains(neighbor.curr)) {
                        queue.offer(neighbor.curr);
                        inQueue.add(neighbor.curr);
                    }
                }
            }
        }
    }

    static class Pair {
        String curr;
        double r;

        Pair(String curr, double r) {
            this.curr = curr;
            this.r = r;
        }
    }
}
