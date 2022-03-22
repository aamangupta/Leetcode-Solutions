class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append('a');
        
        // first making string like this :
        // if(n == 4) sb = "aaaa" and k = 75
        //                     |   (now we are checking from the end by finding the difff of sum and k) if(diff <= 25) this means we got the req. char to be placed into that idx i
        // else we are placing 'z' in that idx i and inc the sum and dec i
        
        // if(n == 4) sb = "aaaa"  sum = 4
        //                   ||| 
        //                   ||z   sum = 29 ans str will look like "aaaz"
        //                   ||      diff = 75 - 29 = 46 (> 25)
        //                   |z    sum = 54 ans str will look like "aazz"
        //                   |       diff = 75 - 54 = 19 (t)
        //                   t       we put "t" and str become "atzz" and we return it
        
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