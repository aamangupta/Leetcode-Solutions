class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int k : nums) set.add(k);
        nums = new int[set.size()];
        int a = 0;
        for(int k : set){
            nums[a] = k;
            a++;
        }
        Arrays.sort(nums);
        int ans = 1, i = 0, j = 0, n = nums.length;
        if(n == 0) return 0;
        while(i < n && j < n - 1){
            if(nums[j] == nums[j + 1] - 1){
                j++;
                ans = Math.max(ans, (j - i + 1));
            } 
            else {
                j++;
                i = j;
            }
        }
        return ans;
    }
}