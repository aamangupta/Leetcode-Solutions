class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        for(int i = 1; i < n; i++){
            int max1 = 0, max2 = 0;
            for(int j = 0; j < i; j++){
                max1 = Math.max(max1, height[j]);
            }
            for(int j = i + 1; j < n; j++){
                max2 = Math.max(max2, height[j]);
            }
            max1 = Math.min(max1, max2);
            if(max1 == 0) continue;
            int diff = max1 - height[i];
            ans = diff < 0 ? ans : ans + (diff);
        }
        return ans;
    }
}