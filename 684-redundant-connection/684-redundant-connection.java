class Solution {
    static int[]par;
    static int[]rank;
    public int find(int x){
        if(par[x] == x) return x;
        par[x] = find(par[x]);
        return par[x];
    }
    public void union(int x, int y, int[]ans){
        int px = find(x);
        int py = find(y);
        if(px == py) {
            ans[0] = x;
            ans[1] = y;
        }else{
            if(rank[px] < rank[py]){
                par[px] = py;
            }else if(rank[px] > rank[py]){
                par[py] = px;
            }else{
                par[py] = px;
                rank[px]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        par = new int[n];
        rank = new int[n];
        for(int i = 1; i < n; i++){
            par[i] = i;
        }
        int []ans = new int[2];
        for(int i[] : edges){
            union(i[0], i[1], ans);
        }
        return ans;
    }
}