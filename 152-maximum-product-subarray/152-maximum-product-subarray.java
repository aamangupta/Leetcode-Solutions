class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1, maxl = nums[0], n = nums.length;
        boolean flag = false;
        for(int i : nums){
            prod *= i;
            maxl = Math.max(maxl, prod);
            if(prod == 0){
                prod = 1;
                flag = true;
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
                flag = true;
                continue;
            }
        }
        int max = Math.max(maxl, maxr);
        // if(flag) return Math.max(max, 0);
        return max;
    }
}