class MKAverage {
    int m, k;
    Queue<Integer> q;
    TreeMap<Integer, Integer> tm; 
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        q = new ArrayDeque<>();
        tm = new TreeMap<>();
    }
    
    public void addElement(int num) {
        q.offer(num);
        tm.put(num, tm.getOrDefault(num, 0) + 1);
        if (q.size() > m) {
            int polled = q.poll();
            int count = tm.get(polled);
            if (count == 1) 
                tm.remove(polled);
            else
                tm.put(polled, count - 1);
        } 
    }
    
    public int calculateMKAverage() {
        if (q.size() < m) return -1;
        long sum = 0;
        int added = 0;
        int ksmall = 0;
        int total = m - (2 * k);

        for (int i : tm.keySet()) {
            int count = tm.get(i);
            int remove = Math.min(k - ksmall, count);

            ksmall += remove;
            count -= remove;
            
            int add = Math.min(total - added, count);
            sum += i * add;
            added += add;
            if (added == total) break;
        }

        return (int) sum / (m - 2 * k);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */