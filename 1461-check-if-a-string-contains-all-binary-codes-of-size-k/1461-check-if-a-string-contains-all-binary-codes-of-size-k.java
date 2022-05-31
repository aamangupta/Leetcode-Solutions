class Solution {
    
    // copied
    // https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/discuss/2092553/Explaining-the-Rolling-Hash-Method-or-Guide
    
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> codes = new HashSet<>();
        int total = 1 << k, allOnes = total - 1, hashCode = 0;
        
        for (int i=0; i<s.length(); i++) {
            hashCode = ((hashCode << 1) & allOnes) | (s.charAt(i) - '0');
            if (i >= k-1 && codes.add(hashCode) && codes.size() == total) return true;
        }
        
        return false;
    }
}