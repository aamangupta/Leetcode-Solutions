class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for(int i : nums){
            pq.add(i);
        }
        int ans = 0;
        for(int i = 0; i < k; i++){
            ans = pq.poll();
        }
        return ans;
    }
}