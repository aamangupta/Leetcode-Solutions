class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, ans = 0;
        for(int i = 0; i < n; i++){
            HashSet<Character>set = new HashSet<>();
            String str = words[i];
            for(int k = 0; k < str.length(); k++) set.add(str.charAt(k));
            for(int j = i + 1; j < n; j++){
                String str1 = words[j];
                boolean flag = true;
                for(int k = 0; k < str1.length(); k++){
                    if(set.contains(str1.charAt(k))) {
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    ans = Math.max(ans, str.length() * str1.length());
                }
            }
        }
        return ans;
    }
}