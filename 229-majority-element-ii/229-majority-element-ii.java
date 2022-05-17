class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        // Moore voting algo
        // there can only be 2 numbers possible that appear more than n/3 
        
        int n = nums.length, c = 1;
        List<Integer> list = new ArrayList<>();
        int c1 = 0, c2 = 0, val1 = -1, val2 = -1;
        
        for(int i : nums){
            if(i == val1) c1++;
            else if(i == val2) c2++;
            else if(c1 == 0){
                val1 = i;
                c1 = 1;
            }else if(c2 == 0){
                val2 = i;
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i : nums){
            if(i == val1) c1++;
            if(i == val2) c2++;
        }
        if(c1 > n/3) list.add(val1);
        if(val1 == val2) return list;
        if(c2 > n/3) list.add(val2);
        return list;
    }
}