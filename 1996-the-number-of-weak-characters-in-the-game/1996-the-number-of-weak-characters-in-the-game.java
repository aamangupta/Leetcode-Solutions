class Solution {
    public int numberOfWeakCharacters(int[][] prop) {
        Arrays.sort(prop,(a,b) -> {
            //0th index -> att, 1th index -> def
            // sort based on attack in decreasing order
        // if attack is equal, sort based on defence in increasing order
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } 
            else {
                return b[0] - a[0];
            }
        });
        int ans = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < prop.length; i++){
            if(prop[i][1] < max){
                ans++;
            }
            max = Math.max(prop[i][1], max);
        }
        return ans;
    }
}