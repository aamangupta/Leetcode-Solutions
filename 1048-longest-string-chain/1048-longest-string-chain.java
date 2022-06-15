class Solution {
    //LIS
    
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
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            String str = words[i];
            for(int j = 0; j < i; j++){
                if(isPre(str, words[j])){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        // for(int i = 0; i < n ;i++){
        //     System.out.print(dp[i] + " ");
        // }
        return ans;
    }
}