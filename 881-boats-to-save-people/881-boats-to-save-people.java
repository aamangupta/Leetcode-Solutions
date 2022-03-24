class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0, n = people.length, i = 0, j = n - 1;
        while(i <= j){
            if(i == j){
                ans++;
                i++;
                j--;
            }else{
                if(people[i] + people[j] <= limit){
                    ans++;
                    i++;
                    j--;
                }else{
                    ans++;
                    j--;
                }
            }
        }
        return ans;
    }
}