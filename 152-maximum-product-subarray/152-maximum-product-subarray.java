class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1, maxl = nums[0], n = nums.length;
        for(int i : nums){
            prod *= i;
            maxl = Math.max(maxl, prod);
            if(prod == 0){
                prod = 1;
                continue;
            }
        }
        prod = 1;
        int maxr = nums[n - 1];
        for(int i = n - 1; i >= 0; i--){
            prod *= nums[i];
            maxr = Math.max(maxr, prod);
            if(prod == 0){
                prod = 1;
                continue;
            }
        }
        int max = Math.max(maxl, maxr);
        return max;
    }
}