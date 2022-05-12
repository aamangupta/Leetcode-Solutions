class Solution {
    public void helper(List<Integer> list, int []nums, int n, HashSet<Integer> set){
        
        if(list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(set.contains(i) == false){
                list.add(nums[i]);
                set.add(i);
                helper(list, nums, n, set);
                set.remove(i);
                list.remove(list.size() - 1);
            }
        }
    }
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        helper(list, nums, n, set);
        return ans;
    }
}