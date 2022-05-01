class Solution {
    public void helper(Stack<Character> st, String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(st.size() > 0) st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        helper(st, s);
        s = "";
        while(st.size() > 0){
            s += st.pop() + "";
        }
        helper(st, t);
        t = "";
        while(st.size() > 0){
            t += st.pop() + "";
        }
        return s.equals(t);
    }
}