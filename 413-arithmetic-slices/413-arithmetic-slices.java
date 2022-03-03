class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int ans = 0;
        for(int i = 0; i < n - 2; i++){
            int j = i + 1;
            int diff = nums[j] - nums[i];
            j++;
            while(j < n){
                int currDiff = nums[j] - nums[j - 1];
                if(currDiff != diff) break;
                else{
                    if((j - i + 1) >= 3) ans++;
                    j++;
                }
            }
        }
        return ans;
    }
}