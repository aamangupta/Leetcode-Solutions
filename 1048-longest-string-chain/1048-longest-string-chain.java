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
        
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        for(String s : words){
            HashSet<String> set = new HashSet<>();
            int l = s.length();
            if(map.containsKey(l) == false){
                set.add(s);
            }else{
                set = map.get(l);
                set.add(s);
            }
            map.put(l, set);
        }
        Map<String, Integer> ref = new HashMap<>();
        for(String s : words) ref.put(s, 1);
        for(String s : words){
            int l = s.length();
            if(map.containsKey(l - 1)){
                HashSet<String> innerSet = map.get(l-1);
                for(String s1 : innerSet){
                    if(isPre(s, s1)){
                        ref.put(s, Math.max(ref.get(s1) + 1, ref.get(s)));
                    }
                }
            }
            ans = Math.max(ref.get(s), ans);
        }
        return ans;
        // Arrays.fill(dp, 1);
        // for(int i = 1; i < n; i++){
        //     String str = words[i];
        //     for(int j = 0; j < i; j++){
        //         if(isPre(str, words[j])){
        //             dp[i] = Math.max(dp[i], 1 + dp[j]);
        //         }
        //     }
        //     ans = Math.max(dp[i], ans);
        // }
        // return ans;
    }
}