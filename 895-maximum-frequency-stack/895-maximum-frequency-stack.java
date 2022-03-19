class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> group = new HashMap<>();
    int maxfreq;
    
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxfreq = Math.max(f, maxfreq);
        
        if(group.containsKey(f) == false){
            Stack<Integer> st = new Stack<>();
            st.push(val);
            group.put(f, st);
        }else{
            Stack<Integer> st = group.get(f);
            st.push(val);
            group.put(f, st);
        }
    }
    
    public int pop() {
        int val = group.get(maxfreq).pop();
        if(group.get(maxfreq).size() == 0){
            group.remove(maxfreq);
            maxfreq--;
        }
        
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */