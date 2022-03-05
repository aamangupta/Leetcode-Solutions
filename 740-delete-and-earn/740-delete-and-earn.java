class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 1;
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(i, max);
        } 
        int s = map.size();
        int arr[] = new int[max + 1], j = 0;
        for(int i : map.keySet()){
            arr[i] = i * map.get(i);
        }
        
        return houserobber(arr);
    }
    public int houserobber(int []arr){
        int no = 0;
        int yes = arr[0], n = arr.length;
        for(int i = 1; i < n; i++){
            int nno = Math.max(yes, no);
            int nyes = no + arr[i];
            
            no = nno;
            yes = nyes;
        }
        return Math.max(no, yes);
    }
}