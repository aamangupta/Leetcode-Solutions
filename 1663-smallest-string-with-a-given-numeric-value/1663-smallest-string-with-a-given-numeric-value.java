class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++) sb.append('a');
        
        int sum = n, i = n - 1;
        while(i >= 0){
            int diff = k - sum;
            if(diff <= 25){
                char ch = (char)('a' + diff);
                sb.replace(i, i + 1, ch + "");
                return sb.toString();
            }else{
                sb.replace(i, i + 1, "z");
                sum += 25;
                i--;
            }
        }
        return "";
    }
}