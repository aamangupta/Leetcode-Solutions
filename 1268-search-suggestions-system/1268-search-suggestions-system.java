class Solution {
    public boolean find(String s1, String s2){
        if(s2.length() < s1.length()) return false;
        for(int i = 0; i < s1.length(); i++){
            if(s2.charAt(i) != s1.charAt(i)) return false;
        }
        return true;
    }
    public List<List<String>> suggestedProducts(String[] prod, String searchWord) {
        Arrays.sort(prod);
        int n = prod.length, m = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            String str = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            
            for(int k = 0; k < n; k++){
                if(list.size() < 3 && find(str, prod[k])){
                    list.add(prod[k]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}