class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1, lmax = height[l], rmax = height[r], ans = 0;
        while(l < r){
            int hl = height[l], rl = height[r];
            if(hl <= rl){
                if(hl >= lmax) lmax = Math.max(lmax, hl);
                else ans += (lmax - hl);
                l++;
            }else{
                if(rl >= rmax) rmax = Math.max(rl, rmax);
                else ans += (rmax - rl);
                r--;
            }
        }
        return ans;
    }
}