class MedianFinder {

    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;

    public MedianFinder() {
        maxPq = new PriorityQueue<>((a,b) -> b-a);
        minPq = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(maxPq.size() == minPq.size()) {
             minPq.offer(num);
             maxPq.offer(minPq.poll());
        } else {
            maxPq.offer(num);
            minPq.offer(maxPq.poll());
        }
    }
    
    public double findMedian() {
        if(maxPq.size() == minPq.size()) { 
            return (maxPq.peek() +  minPq.peek())/2.0;
        } else {
            return maxPq.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */