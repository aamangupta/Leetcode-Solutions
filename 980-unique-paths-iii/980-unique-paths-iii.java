class Solution {
    
    int count  = 0;
    public int uniquePathsIII(int[][] grid) {
        
        if (grid == null || grid.length == 0){
            return 0;
        }
            
        int m = grid.length;
        int n = grid[0].length;
        int countZero = 1;   
        //loop to count 0's in the matrix
        for(int currentRow = 0; currentRow < m; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                if(grid[currentRow][currentCol] == 0){
                    countZero++;
                }
            }
        }
        
        //loop to find value 1 in the matrix and then make a call to function totalWays
        for(int currentRow = 0; currentRow < m; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                if(grid[currentRow][currentCol] == 1){
                    totalWays(grid, currentRow, currentCol, m, n, countZero);
                }
            }
        }
        
        return count; 
    }
    
    private int totalWays(int[][] grid, int currentRow, int currentCol, int m, int n, int countZero){
        
        if(currentRow >= m || currentCol >= n || currentRow < 0 || currentCol < 0 || grid[currentRow][currentCol] == -1 || grid[currentRow][currentCol] == -2){
            return 0;
        }
        
        if(grid[currentRow][currentCol] == 2 && countZero == 0){
            count++;
            return count;
        }
        
    
        int temp = grid[currentRow][currentCol];
        grid[currentRow][currentCol] = -2;
        
        int right = totalWays(grid, currentRow, currentCol+1, m, n, countZero-1);
        int left = totalWays(grid, currentRow, currentCol-1, m, n, countZero-1);
        int up = totalWays(grid, currentRow-1, currentCol, m, n, countZero-1);
        int down = totalWays(grid, currentRow+1, currentCol, m, n, countZero-1);
        
        grid[currentRow][currentCol] = temp;
        return (right+left+up+down);
        
    }
    
}