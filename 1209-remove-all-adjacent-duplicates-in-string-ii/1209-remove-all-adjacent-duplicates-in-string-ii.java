class Solution {
    public class pair{
        char ch;
        int freq;
        pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        int i = 1, n = s.length();
        Stack<pair> st = new Stack<>();
        st.push(new pair(s.charAt(0), 1));
        while(i < n){
            char cha = s.charAt(i);
            
            if(st.size() > 0 && st.peek().ch == cha){
                int fre = st.pop().freq + 1;
                st.push(new pair(cha, fre));
            }else{
                st.push(new pair(cha, 1));
            }
            i++;
            if(st.peek().freq == k) st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            pair rem = st.pop();
            int f = rem.freq;
            char cha = rem.ch;
            for(i = 0; i < f; i++){
                sb.append(cha);
            }
        }
        sb.reverse();
        return sb.toString();
    }
}