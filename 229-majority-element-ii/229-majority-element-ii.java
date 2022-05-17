class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, c = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]) c++;
            else{
                if(c > n/3) list.add(nums[i - 1]);
                c = 1;
            }
        }
        if(c > n/3) list.add(nums[n - 1]);
        return list;
    }
}