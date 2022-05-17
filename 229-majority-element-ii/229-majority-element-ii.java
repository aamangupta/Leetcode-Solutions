class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i: map.keySet()){
            if(map.get(i) > n/3){
                list.add(i);
            }
        }
        return list;
    }
}