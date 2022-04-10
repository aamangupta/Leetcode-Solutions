class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(String s : ops){
            if(s.equals("D")){
                int val = (st.peek() * 2);
                st.push(val);
            }else if(s.equals("C")){
                st.pop();
            }else if(s.equals("+")){
                int rem = st.pop();
                int val = rem + st.peek();
                st.push(rem);
                st.push(val);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        while(st.size() > 0){
            ans += (st.pop());
        }
        return ans;
    }
}