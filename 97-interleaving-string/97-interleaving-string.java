class Solution {
    // taking 3 pts for s1,s2,s3 and checking the char from s3 if they are eq to char at s1 or s2
    //     in case char at s2 == char at s1 then recursively check from both the conditions
    //     and return accordingly
    
    public boolean helper(String s1, String s2, String s3, int i1, int i2, int i3, Boolean [][]dp){
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        
        if(i1 == n1 && i2 == n2 && i3 == n3) return true;
        
        if(dp[i1][i2] != null) return dp[i1][i2];
        
        if(i1 < n1 && i3 < n3 && i2 < n2 && s3.charAt(i3) == s2.charAt(i2) && s3.charAt(i3) == s1.charAt(i1)){
            boolean ans1 = helper(s1, s2, s3, i1 + 1, i2, i3 + 1,dp);
            if(ans1) return dp[i1][i2] = true;
            boolean ans2 = helper(s1, s2, s3, i1, i2 + 1, i3 + 1,dp);
            return dp[i1][i2] = ans2;
            
            
        }else if(i1 < n1 && i3 < n3 && s1.charAt(i1) == s3.charAt(i3)){
            
            return dp[i1][i2] = helper(s1,s2,s3,i1 + 1, i2, i3 + 1,dp);
            
        }else if(i2 < n2 && i3 < n3 && s2.charAt(i2) == s3.charAt(i3)){
            
            return dp[i1][i2] = helper(s1,s2,s3,i1, i2 + 1, i3 + 1,dp);
            
        }
        else return dp[i1][i2] = false;
        
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n3 > (n1 + n2)) return false;
        Boolean dp[][] = new Boolean[n1+1][n2+1];
        return helper(s1, s2, s3, 0,0,0,dp);    
    }
}