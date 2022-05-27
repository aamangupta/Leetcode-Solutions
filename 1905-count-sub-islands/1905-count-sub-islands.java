class Solution {
    public void helper(int [][]arr, int i, int j, Set<Integer> set, int [][]grid1){
        int n = arr.length, m = arr[0].length, box = i * m + j;
        if(grid1[i][j] == 0) flag = true;
        set.add(box);
        arr[i][j] = 0;
        int dir[] = {0,1,0,-1,0};
        for(int k = 0; k < 4; k++){
            int ni = i + dir[k], nj = j + dir[k + 1];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && arr[ni][nj] == 1){
                helper(arr, ni, nj, set, grid1);
            }
        }
    }
    List<Set<Integer>> g2 = new ArrayList<>();
    boolean flag = false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    flag = false;
                    Set<Integer> set = new HashSet<>();
                    helper(grid2, i, j, set, grid1);
                    g2.add(set);
                    if(flag == false) ans++;
                }
            }
        }
        return ans;
    }
}