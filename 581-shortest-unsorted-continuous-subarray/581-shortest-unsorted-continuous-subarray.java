class Solution {
    public class pair{
        int idx , val;
        pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int findUnsortedSubarray(int[] nums) {
        Stack<pair> st = new Stack<>();
        int n = nums.length, start = n-1, end = -1;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            if(st.size() > 0 && st.peek().val > val){
                while(st.size() > 0 && st.peek().val > val){
                    start = Math.min(start, st.pop().idx);
                }
                // break;
            }else st.push(new pair(val, i));
        }
        st = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--){
            int val = nums[i];
            if(st.size() > 0 && st.peek().val < val){
                while(st.size() > 0 && st.peek().val < val){
                    end = Math.max(end, st.pop().idx);
                }
                // break;
            }else st.push(new pair(val, i));
        }
        // System.out.println(start + " " + end);
        if(start == n - 1) return 0;
        return end - start + 1;
    }
}