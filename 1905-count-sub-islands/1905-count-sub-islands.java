class Solution {
    public void helper1(int [][]arr, int i, int j){
        int n = arr.length, m = arr[0].length, box = i * m + j;
        g1.add(box);
        arr[i][j] = 0;
        int dir[] = {0,1,0,-1,0};
        for(int k = 0; k < 4; k++){
            int ni = i + dir[k], nj = j + dir[k + 1];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && arr[ni][nj] == 1){
                helper1(arr, ni, nj);
            }
        }
    }
    public void helper(int [][]arr, int i, int j, Set<Integer> set){
        int n = arr.length, m = arr[0].length, box = i * m + j;
        set.add(box);
        arr[i][j] = 0;
        int dir[] = {0,1,0,-1,0};
        for(int k = 0; k < 4; k++){
            int ni = i + dir[k], nj = j + dir[k + 1];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && arr[ni][nj] == 1){
                helper(arr, ni, nj, set);
            }
        }
    }
    Set<Integer> g1 = new HashSet<>();
    List<Set<Integer>> g2 = new ArrayList<>();
    public void fill(int [][]grid, List<Set<Integer>> g){
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    Set<Integer> set = new HashSet<>();
                    helper(grid, i, j, set);
                    g.add(set);
                }
            }
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        fill(grid2, g2);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid1[i][j] == 1){
                    helper1(grid1, i, j);
                }
            }
        }
        int ans = 0;
        boolean flag = false;
        for(Set<Integer> s : g2){
            for(int i : s){
                if(g1.contains(i) == false) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) ans++;
            else flag = false;
        }
        return ans;
        
    }
}