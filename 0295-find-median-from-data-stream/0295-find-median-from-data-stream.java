class MedianFinder {
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;
    public MedianFinder() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minPq.size() == maxPq.size()) {
            maxPq.offer(num);
            minPq.offer(maxPq.poll());
        } else {
            minPq.offer(num);
            maxPq.offer(minPq.poll());
        }
    }
    
    public double findMedian() {
        if(minPq.size() == maxPq.size()) {
            return (minPq.peek() + maxPq.peek())/2.0;
        } else {
            return minPq.peek();
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */