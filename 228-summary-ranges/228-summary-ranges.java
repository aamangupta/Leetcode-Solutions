class Solution {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            while(i < n - 1 && nums[i] + 1 == nums[i + 1]) i++;
            if(nums[i] != num){
                sb.append(num);
                sb.append("->");
                sb.append(nums[i]);
                list.add(sb.toString());
            }else{
                sb.append(num);
                list.add(sb.toString());
            }
            sb = new StringBuilder();
        }
        return list;
    }
}