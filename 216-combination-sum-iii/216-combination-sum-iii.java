class Solution {
    public void helper(int st, int sum, int k, int n, List<Integer> list){
        if(list.size() == k && sum == n){
            ans.add(new ArrayList(list));
            return;
        }
        if(list.size() == k && sum != k) return;
        
        for(int i = st + 1; i <= 9; i++){
            list.add(i);    
            helper(i, sum + i, k, n, list);
            list.remove(list.size() - 1);
        }    
    }
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        
        helper(0,0,k,n,list);
        return ans;
    }
}