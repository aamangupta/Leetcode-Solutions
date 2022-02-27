class Solution {
    public int[] searchRange(int[] nums, int target) {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(first.containsKey(nums[i]) == false) first.put(nums[i], i);
            last.put(nums[i], i);
        }
        int ans[] = new int[2];
        if(first.containsKey(target) == false){
            ans[0] = -1;
        }else ans[0] = first.get(target);
        if(last.containsKey(target) == false){
            ans[1] = -1;
        }else ans[1] = last.get(target);
        return ans;
    }
}