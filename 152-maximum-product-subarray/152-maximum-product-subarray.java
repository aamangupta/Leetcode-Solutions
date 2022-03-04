class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int prod = nums[i];
            max = Math.max(max, prod);
            for(int j = i + 1; j < n; j++){
                prod *= nums[j];
                max = Math.max(max, prod);
            }
        }
        return max;
    }
}