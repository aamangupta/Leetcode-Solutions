class Solution {
    public boolean help(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length(), j = n - 1, i = 0;
        boolean flag = false;
        while(i <= j){
            int ci = s.charAt(i), cj = s.charAt(j);
            if(ci != cj && flag == false){
                flag = true;
                return help(i + 1, j,s) || help(i, j - 1, s);
            }else if(ci != cj && flag == true) return false;
            else {
                i++;j--;
            }
        }
        return true;
    }
}