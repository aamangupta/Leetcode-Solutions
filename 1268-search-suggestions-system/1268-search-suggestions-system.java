class Solution {
    // -Sorting the array(we want lexicographically ans)
    // -travelling through all the substings of the searhword string 
    // -now comparing in the prod array for all the ele in it with if that prefix 
    //  is present in that ele or not.
    //     also limiting it till 3 string 
    // -adding in the ans AL
    
    
    public boolean find(String pref, String str){
        if(str.length() < pref.length()) return false;
        for(int i = 0; i < pref.length(); i++){
            if(str.charAt(i) != pref.charAt(i)) return false;
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