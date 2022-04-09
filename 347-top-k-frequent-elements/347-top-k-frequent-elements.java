class Solution {
    public class pair implements Comparable<pair>{
        int i;
        int freq;
        pair(int i, int freq){
            this.i = i;
            this.freq = freq;
        }
        public int compareTo(pair o){
            return o.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int j = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i : map.keySet()){
            pq.add(new pair(i, map.get(i)));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            pair rem = pq.poll();
            list.add(rem.i);
        }
        j = 0;
        int []ans = new int[list.size()];
        for(int i : list){
            ans[j] = i;
            j++;
        }
        return ans;   
    }
}