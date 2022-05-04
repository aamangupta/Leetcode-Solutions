class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,(map.getOrDefault(i,0) + 1));
        }
        int ans = 0;
        for(int i : nums){
            int find = k - i;
            if(find == i && map.containsKey(i) && map.get(i) >= 2){
                int frq = map.get(i) - 2;
                if(frq == 0) map.remove(i);
                else map.put(i, frq);
                ans++;
            }
            else if(find != i && map.containsKey(i) && map.containsKey(find)){
                
                if(map.get(i) == 1) map.remove(i);
                else map.put(i, map.get(i) - 1);
                if(map.get(find) == 1) map.remove(find);
                else map.put(find, map.get(find) - 1);
                ans++;
            }
        }
        return ans;
    }
}