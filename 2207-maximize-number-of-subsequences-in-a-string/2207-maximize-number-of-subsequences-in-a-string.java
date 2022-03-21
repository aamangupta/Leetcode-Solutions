class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ca = 0, cb = 0, n = text.length();
        long res = 0;
        char a = pattern.charAt(0), b = pattern.charAt(1);
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            if(ch == a) ca++;
            if(ch == b) cb++;
        }
        
        if(a == b) return ca * (ca + 1) / 2;
        if(ca < cb) res += cb;
        else cb++;
        
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            if(ch == a) res += cb;
            else if(ch == b) cb--;
        }
        return res;
    }
}