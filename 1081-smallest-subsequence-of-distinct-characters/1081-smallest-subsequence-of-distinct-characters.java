class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        boolean []flag = new boolean[26];
        int []last = new int[26];
        for(int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(flag[ch - 'a'] == false){
                while(st.size() > 0 && st.peek() > ch && last[st.peek() - 'a'] > i){
                    char c = st.pop();
                    flag[c - 'a'] = false;
                }
                st.push(ch);
                flag[ch - 'a'] = true;
            }
        }
        String ans = "";
        while(st.size() > 0){
            ans += st.pop();
        }
        StringBuilder sb=new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }
}