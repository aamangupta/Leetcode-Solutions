class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int i : nums){
            if(set.contains(i - 1)) continue;
            else{
                int cnt = 1;
                while(set.contains(i + 1)){
                    cnt++;
                    i = i + 1;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}