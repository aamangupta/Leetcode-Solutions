class Solution {
    public boolean check(int []arr){
        int n = arr.length;
        if(n < 2) return false;
        Arrays.sort(arr);
        for(int i = 1; i < n; i++){
            if(arr[i] - arr[i - 1] != arr[1] - arr[0]) return false;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            int lo = l[i];
            int hi = r[i];
            if(hi == lo) {
                ans.add(false);
                continue;
            } 
            int len = hi - lo + 1;
            int arr[] = new int[len];
            for(int j = lo, k = 0; j <= hi; j++, k++){
                arr[k] = nums[j];
            }
            ans.add(check(arr));
        }
        return ans;
    }
}