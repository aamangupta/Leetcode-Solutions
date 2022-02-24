class Solution {
    public int maxArea(int[] height) {
        int ans = 0, n = height.length, i = 0, j = n - 1;
        while(j > i){
            int n1 = height[i], n2 = height[j];
            int cap = (j - i) * Math.min(n2, n1);
            ans = Math.max(cap, ans);
            if(n1 > n2) j--;
            else i++;
        }
        return ans;
    }
}