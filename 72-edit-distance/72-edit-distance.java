class Solution {
    public int helper(String w1, String w2, int i, int j, int [][]dp){
        if(i == w1.length()) return w2.length() - j;
        if(j == w2.length()) return w1.length() - i;
        char c1 = w1.charAt(i), c2 = w2.charAt(j);
        if(dp[i][j] != -1) return dp[i][j];
        if(c1 == c2){
            dp[i][j] = helper(w1, w2, i + 1, j + 1, dp);
        // --- using recursion we are exoloring all the posssiblities
        }else{
            dp[i][j] = Math.min(helper(w1, w2, i, j + 1, dp), // insertion
                            Math.min(helper(w1, w2, i + 1, j, dp), // deletion
                                     helper(w1, w2, i + 1, j + 1, dp))) + 1; // replacing
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(word1, word2, 0, 0, dp);
    }
}