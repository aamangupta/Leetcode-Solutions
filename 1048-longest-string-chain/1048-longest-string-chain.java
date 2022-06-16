class Solution {
    //LIS's Variation
    // like in LIS we are sorting the array acc to length
    // now checking for every index and comparing it with all the previous 
    // string if pre. str is a predecesoor of curr str or not 
    //     if yes then update the dp[i] with max among them
    //         also update the ans var.
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        int n = words.length, ans = 1, dp[] = new int[n];
        
        Map<String, Integer> ref = new HashMap<>();
        for(String s : words) ref.put(s, 1);
        for(String s : words){
            int l = s.length();
            for(int i = 0; i < l; i++){
                String str = s.substring(0, i) + s.substring(i + 1);
                if(ref.containsKey(str)){
                    ref.put(s, Math.max(ref.get(str) + 1, ref.get(s)));
                }
            }
            ans = Math.max(ref.get(s), ans);
        }
        return ans;
    }
}