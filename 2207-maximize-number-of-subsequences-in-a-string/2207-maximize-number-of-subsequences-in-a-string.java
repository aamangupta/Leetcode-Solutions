class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ca = 0, cb = 0, n = text.length();
        long res = 0;
        char a = pattern.charAt(0), b = pattern.charAt(1);
        
        // here ca will store the occurance of pattern[0] and cb store occ of patt[1]
        
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            if(ch == a) ca++;
            if(ch == b) cb++;
        }
        
        // if(a == b) ex. text = "aaaa", patt = "aa", so if we add 'a' at start or end no change 
        // the ans will be 4 + 3 + 2 + 1 this means sum of n number here n is occ of 'a'
        // so we return (n * n++)/ 2;
        if(a == b) return ca * (ca + 1) / 2;
        
        // if ca < cb, this means we need to add patt[0] at the start of text str
        // this will inc res by cb, kyuki start m lagaya hai to baaki saare b's add hoge subseq
        // bante time
        if(ca < cb) res += cb;
        
        // else we will place patt[1] at the end of str
        else cb++;
        
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            
            // if(ch == a) toh jitne b hai aage wo add hoge answer mai
            if(ch == a) res += cb;
            // else b kam hojeaga
            else if(ch == b) cb--;
        }
        return res;
    }
}