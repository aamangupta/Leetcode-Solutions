class Solution {
        public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        // this array will store the freq of characters
        int freq[] = new int[26];
        for(int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
        
        // this will store occurance of that character
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, counter = 0;
        while(j < n){
            char ch = s.charAt(j);
            if(set.contains(ch) == false){
                set.add(ch);
                counter++;
            }
            j++;
            freq[ch - 'a']--;
            if(freq[ch - 'a'] == 0){
                set.remove(ch);
                counter--;
            }
            if(counter == 0){
                ans.add(j - i);
                i = j;
            }
            
        }
        return ans;
    }
}