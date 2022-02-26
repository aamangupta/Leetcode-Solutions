class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n - 1, n, ans, "(");
        return ans;
    }
    public void helper(int open, int close, List<String> ans, String str){
        if(open > close) return;
        if(open == 0 && close == 0) {
            ans.add(str);
            return;
        }
        if(open > 0) helper(open - 1, close, ans, str + "(");
        if(close > 0) helper(open , close - 1, ans, str + ")");
    }
}