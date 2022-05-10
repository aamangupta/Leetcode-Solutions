class Solution {
    public void helper(List<List<Integer>> ans, int st, int sum, int k, int n, List<Integer> list){
        if(list.size() == k && sum == n){
            ans.add(new ArrayList(list));
            return;
        }
        if(list.size() == k && sum != k) return;
        
        for(int i = st + 1; i <= 9; i++){
            list.add(i);    
            helper(ans, i, sum + i, k, n, list);
            list.remove(list.size() - 1);
        }    
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(ans,0,0,k,n,list);
        return ans;
    }
}