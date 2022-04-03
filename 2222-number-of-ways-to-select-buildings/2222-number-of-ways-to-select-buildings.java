class Solution {
    public long numberOfWays(String s) {
        
        // there are only 2 combinations :
        // 010 and 101
        //     (noc = no. of combinations)
        //     in 010 : when we get s.charAT(i) == '1' then noc = ans + no.of 0 before i * no.of 0 after i
        //     in 101 : when we get s.charAT(i) == '0' then noc = ans + no.of 1 before i * no.of 1 after i
        long ans = 0, n = s.length(), t0 = 0, t1 = 0, curr0 = 0, curr1 = 0;
        for(int i = 0; i < n; i++){
            t0 += (s.charAt(i) == '0'? 1 : 0);
            t1 += (s.charAt(i) == '1'? 1 : 0);
        }
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                ans += (curr1 * (t1 - curr1));
                curr0++;
            }else{
                ans += (curr0 * (t0 - curr0));
                curr1++;
            }
        }
        return ans;
    }
}