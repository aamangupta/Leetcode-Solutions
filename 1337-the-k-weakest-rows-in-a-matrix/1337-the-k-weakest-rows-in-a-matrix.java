class Solution {
    public class pair{
        int idx;
        int val;
        pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        pair []ans = new pair[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1) count++;
            }
            ans[i] = new pair(i, count);
        }
        Arrays.sort(ans, (a,b) -> {
            if(a.val == b.val) return a.idx - b.idx;
            else return a.val - b.val;
        });
        int fans[] = new int[k];
        for(int i = 0; i < k; i++){
            fans[i] = ans[i].idx;
        }
        return fans;
    }
}