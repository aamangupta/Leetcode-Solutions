class Solution {
    //LIS's Variation
    // like in LIS we are sorting the array acc to length
    // now checking for every index and comparing it with all the previous 
    // string if pre. str is a predecesoor of curr str or not 
    //     if yes then update the dp[i] with max among them
    //         also update the ans var.
    
    public boolean isPre(String s1, String s2){
        if(s1.length() != s2.length() + 1){
            return false;
        }else{
            for(int i = 0; i < s1.length(); i++){
                String str = s1.substring(0, i) + s1.substring(i + 1);
                if(str.equals(s2)) return true;
            }
            return false;
        }
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        
        int n = words.length, ans = 1, dp[] = new int[n];
        
        Map<String, Integer> ref = new HashMap<>();
        for(String s : words) ref.put(s, 1);
        for(String s : words){
            int l = s.length();
            for(String s1 : ref.keySet()){
                if(isPre(s, s1)){
                    ref.put(s, Math.max(ref.get(s1) + 1, ref.get(s)));
                }
            }
            ans = Math.max(ref.get(s), ans);
        }
        return ans;
    }
}