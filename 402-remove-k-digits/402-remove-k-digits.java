class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch1 = num.charAt(i);
            int i1 = Integer.parseInt(ch1 + "");
            while(st.size() > 0 && k > 0 && st.peek() > i1) {
                st.pop();
                k--;
            }
            st.push(i1);
        }
        while(k > 0){
            st.pop();
            k--;
        }   
        while(st.size() > 0){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}