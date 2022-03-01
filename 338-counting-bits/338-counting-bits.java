class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            ans[i] = bits(i);
        }
        return ans;
    }
    public int bits(int n){
        if(n == 1 || n == 0) return n;
        
        if(n % 2 == 0) return bits(n/2);
        else return 1 + bits(n/2);
    }
}