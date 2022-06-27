class MedianFinder {

    PriorityQueue<Integer> small, large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    public void helper(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2, int val){
        int rem = q2.remove();
        q2.add(val);
        q1.add(rem);
    }
    public void addNum(int num) {
        int ss = small.size(), ls = large.size();
        if(ss == ls){
            if(ls > 0 && num > large.peek()){
                helper(small, large, num);
            }else small.add(num);
        }else if(ss < ls){
            if(ls > 0 && num > large.peek()){
                helper(small, large, num);
            }else small.add(num);
        }else{
            if(ss > 0 && num < small.peek()){
                helper(large, small, num);
            }else large.add(num);
        }
    }
    
    public double findMedian() {
        int ss = small.size(), ls = large.size();
        if(ss == ls){
            return (small.peek() + large.peek()) / 2.0;
        }else if(ss < ls){
            return large.peek();
        }else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */