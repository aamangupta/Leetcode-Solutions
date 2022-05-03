class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // brute : nlong
        int n = nums.length, arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }
        
        Arrays.sort(arr);
        int i1 = -1, i2 = -1;
        for(int i = 0; i < n; i++){
            if(i1 == -1 && arr[i] != nums[i]) i1 = i;
            else if(arr[i] != nums[i]) i2 = i;
        }
        if(i1 == -1 && i2 == -1) return 0;
        else return i2 - i1 + 1;
    }
}