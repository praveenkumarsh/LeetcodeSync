class MedianFinder {
    
    PriorityQueue<Integer> minP, maxP;

    /** initialize your data structure here. */
    public MedianFinder() {
        minP = new PriorityQueue<Integer>();
        maxP = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxP.add(num);
        minP.add(maxP.poll());
        
        if(minP.size()>maxP.size()){
            maxP.add(minP.poll());
        }
    }
    
    public double findMedian() {
        if(minP.size()==maxP.size()){
            return (double)(maxP.peek()+minP.peek())/2;
        }else{
            return (double) maxP.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
