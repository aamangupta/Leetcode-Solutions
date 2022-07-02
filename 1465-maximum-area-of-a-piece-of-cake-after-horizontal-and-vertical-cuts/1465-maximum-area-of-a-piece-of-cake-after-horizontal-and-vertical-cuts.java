class Solution {
    public int breadthMaker(int c, int arr[]){
        int prev = 0, ans = 0;
        for(int i : arr){
            ans = Math.max(ans, i - prev);
            prev = i;
        }
        ans = Math.max(ans, c - prev);
        return ans;
    }
    int mod = 1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int breadth = breadthMaker(w, verticalCuts);
        int len = breadthMaker(h, horizontalCuts), ans = 0;
        long area = 1L * len * breadth;
        return (int)(area % mod);
    }
}