class Solution {
    int min = Integer.MAX_VALUE;
    public int minDominoRotations(int[] A, int[] B) {
        minDominoRotations(A,B,A[0]); 
        minDominoRotations(A,B,B[0]); 
        minDominoRotations(B,A,A[0]);
        minDominoRotations(B,A,B[0]);
        return min==Integer.MAX_VALUE?-1:min;
    }
    
    public void minDominoRotations(int[] A, int[] B, int n) {
        int sum = 0;
        for (int i=0;i<A.length;i++){
            if (A[i]!=n && B[i]!=n)return;
            else if (A[i]!=n && B[i]==n)sum++;
        }
        min = Math.min(min, sum);
    }
}