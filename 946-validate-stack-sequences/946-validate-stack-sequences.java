class Solution {
    public boolean validateStackSequences(int[] pushed, int[] poped) {
        int n = pushed.length, i = 1, j = 0;
        if(n == 1) return true;
        Stack<Integer> st = new Stack<>();
        st.push(pushed[0]);
        int prev = pushed[0];
        while(i < n && j < n){
            while(i < n && prev != poped[j]){
                prev = pushed[i];
                st.push(pushed[i]);
                i++;
            }
            while(j < n && st.size() > 0 && st.peek() == poped[j]){
                st.pop();
                j++;
            }
        }
        if(st.size() == 0) return true;
        return false;
    }
}