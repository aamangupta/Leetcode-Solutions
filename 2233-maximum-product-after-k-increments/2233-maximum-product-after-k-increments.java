class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = (int)Math.pow(10, 9) + 7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
        }
        for(int i = 0; i < k; i++){
            int rem = pq.remove();
            pq.add(rem + 1);
        }
        long ans = 1L;
        while(pq.size() != 0){
            ans *= pq.remove();
            ans %= mod;
        }
        return (int)ans;
    }
}