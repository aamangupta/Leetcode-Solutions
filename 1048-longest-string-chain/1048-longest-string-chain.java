class Solution {

    // here we are sorting
    //     and iterating to every string in array
    //     then checking all the subseq if it is presnt in the ref map
    //         if yes then update the map
    //     update the ans var
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        int n = words.length, ans = 1, dp[] = new int[n];
        
        Map<String, Integer> ref = new HashMap<>();
        for(String s : words) ref.put(s, 1);
        for(String s : words){
            int l = s.length();
            for(int i = 0; i < l; i++){
                String str = s.substring(0, i) + s.substring(i + 1);
                if(ref.containsKey(str)){
                    ref.put(s, Math.max(ref.get(str) + 1, ref.get(s)));
                }
            }
            ans = Math.max(ref.get(s), ans);
        }
        return ans;
    }
}