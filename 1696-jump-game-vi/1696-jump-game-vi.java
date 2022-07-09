// copied
// https://leetcode.com/problems/jump-game-vi/discuss/2257930/Sliding-Window-And-Priority-Queue
class Solution {
    
    public int maxResult(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        
        // To reach at index 0, maxScore is nums[0]
        int maxScore = nums[0];
        
        // [index, max], maxScore will at top
        PriorityQueue<int[]> pq = new  PriorityQueue<>((a,b)->b[1]-a[1]);
        
        //add first index and its score at top
        pq.offer(new int[]{0, nums[0]});
        
        // now, we find maxScore to reach till ith index
        for(int i=1; i<nums.length; i++){
            // if (i-peek[])<=k 
            while(!(i-pq.peek()[0]<=k)){
                pq.poll();
            }
            // get the peek of queue
            int[] top = pq.peek();
            maxScore = top[1] + nums[i];
            // get maxScore and add it queue
            pq.offer(new int[]{i, maxScore});
        }
        return maxScore;
        
    }
}