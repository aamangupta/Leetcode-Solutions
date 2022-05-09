class Solution {
    HashMap<Character, String> map;
    public void helper(String digits, int k, String str, List<String> ans, HashMap<Character, String> map){
        if(k > digits.length()) return;
        if(str.length() == digits.length()){
            ans.add(str);
            // System.out.println(str);
            return;
        }
        
        for(int i = 0; i < map.get(digits.charAt(k)).length(); i++){
            helper(digits, k+1, str + (map.get(digits.charAt(k)).charAt(i)) + "", ans, map);
        }
    }
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, 0, "", ans, map);
        return ans;
    }
}
