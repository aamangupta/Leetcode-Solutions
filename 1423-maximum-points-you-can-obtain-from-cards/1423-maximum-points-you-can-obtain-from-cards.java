class Solution {
    // the ques now becomes min subarray of size n - k;
    
    public int maxScore(int[] cardPoints, int k) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE, n = cardPoints.length, size = n - k;
        while(j < n){
            int winSize = j - i + 1;
            if(winSize < size){
                sum += cardPoints[j];
                j++;
            }else if(winSize == size){
                sum += cardPoints[j];
                min = Math.min(sum, min);
                j++;
            }else{
                sum -= cardPoints[i];
                i++;
            }
        }
        sum = 0;
        for(int kk : cardPoints) sum += kk;
        return sum - min;
    }
}