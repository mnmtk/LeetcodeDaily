class MedianFinder {

    PriorityQueue<Integer> maxPqLeft;
    PriorityQueue<Integer> minPqRight;

    public MedianFinder() {
        maxPqLeft = new PriorityQueue<>((a,b) -> b-a);
        minPqRight = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(maxPqLeft.size() == minPqRight.size()) {
             minPqRight.offer(num);
             maxPqLeft.offer(minPqRight.poll());
        } else {
            maxPqLeft.offer(num);
            minPqRight.offer(maxPqLeft.poll());
        }
    }
    
    public double findMedian() {
        if(maxPqLeft.size() == minPqRight.size()) { 
            return (maxPqLeft.peek() +  minPqRight.peek())/2.0;
        } else {
            return maxPqLeft.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */