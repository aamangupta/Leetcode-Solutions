class Solution {
    public String helper(String s){
        String s1 = "";
        int c = 0, n = s.length();
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '#') c++;
            else if(ch != '#' && c == 0){
                s1 += ch+"";
            }else c--;
        }
        return s1;
    }
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }
}