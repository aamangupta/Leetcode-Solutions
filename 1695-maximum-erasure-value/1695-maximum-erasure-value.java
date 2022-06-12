class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 1;
        int sum = 0, n = nums.length, i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        while(j < n && i < n){
            if(set.contains(nums[j]) == false){
                sum += nums[j];
                ans = Math.max(sum, ans);
                set.add(nums[j]);
                j++;
            }else{
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return ans;
    }
}