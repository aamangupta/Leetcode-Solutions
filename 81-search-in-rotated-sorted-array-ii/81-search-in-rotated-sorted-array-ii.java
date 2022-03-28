class Solution {
    public boolean search(int[] numz, int target) {
        ArrayList<Integer> nums = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i : numz){
            if(set.contains(i) == false){
                set.add(i);
                nums.add(i);
            }
        }
        
        
        int hi = nums.size() - 1;
        int lo = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums.get(mid) == target) return true;
            if(nums.get(lo) <= nums.get(mid)){
                if(target >= nums.get(lo) && target <= nums.get(mid)) {
                    hi = mid - 1;
                }else lo = mid + 1;
            }else if(nums.get(mid) <= nums.get(hi)){
                if(target >= nums.get(mid) && target <= nums.get(hi)) {
                    lo = mid + 1;
                }else hi = mid - 1;
            }
        }
        return false;
    }
}