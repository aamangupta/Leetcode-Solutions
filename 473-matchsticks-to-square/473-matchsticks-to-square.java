class Solution {
    public void rev(int []arr){
        int i = 0, j = arr.length- 1;
        while(i < j){
            int a = arr[j];
            arr[j] = arr[i];
            arr[i] = a;
            i++;
            j--;
        }
    }
    public boolean makesquare(int[] matchsticks) {
        int per = 0;
        Arrays.sort(matchsticks);
        rev(matchsticks);
        for(int i : matchsticks) per += i;
        if(per % 4 != 0) return false;
        int side = per / 4, sq[] = new int[4];
        Arrays.fill(sq, side);
        return helper(sq, matchsticks, 0);
    }
    public boolean helper(int []arr, int []match, int i){
        
        if(i == match.length){
            return arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0;
        }
        
        for(int j = 0; j < 4; j++){
            if(match[i] > arr[j]) continue;
            arr[j] -= match[i];
            if(helper(arr, match, i + 1) == true) return true;
            arr[j] += match[i];
        }
        return false;
    }
}