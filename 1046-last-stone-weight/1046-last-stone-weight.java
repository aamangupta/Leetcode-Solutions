class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) q.add(i);
        
        while(q.size() > 1){
            int a = q.poll(), b = q.poll();
            if(a == b){
                
            }else{
                q.offer(a - b);
            }
        }
        return q.size() > 0 ? q.poll() : 0;
    }
}