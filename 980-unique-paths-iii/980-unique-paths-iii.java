class Solution {
    int dir[][] = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    
    public void helper(int [][]arr, int si, int sj, boolean[][]vis, ArrayList<Integer> list, int total){
        int n = arr.length, m = arr[0].length;
        int box = si * m + sj;
        
        if(arr[si][sj] == 2){
            list.add(box);
            if(list.size() == total ){
                paths.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        
        vis[si][sj] = true;
        list.add(box);
        
        for(int i = 0; i < 4; i++){
            int ni = si + dir[i][0];
            int nj = sj + dir[i][1];
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && arr[ni][nj] != -1 && vis[ni][nj] == false){
                helper(arr, ni, nj, vis, list, total);
            }
        }    
        vis[si][sj] = false;
        list.remove(list.size() - 1);
    }
    
    
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length, block = 0, sti = 0, stj = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == -1) block++;
                else if(grid[i][j] == 1){
                    sti = i;
                    stj = j;
                }
            }
        }
        int total = (n * m) - block;
        boolean[][]vis = new boolean[n][m];
        helper(grid, sti, stj, vis, new ArrayList<>(), total);
        return paths.size();
    }
}