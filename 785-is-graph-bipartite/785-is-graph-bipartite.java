class Solution {
    public boolean helper(int i, int [][]graph, int[]colors, int color){
        if(colors[i] != 0){
            if(colors[i] != color) return false;
            else return true;
        }
        
        colors[i] = color;
        for(int it : graph[i]){
            boolean ch = helper(it, graph, colors, -color);
            if(ch == false) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length, color[] = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                boolean ch = helper(i, graph, color, 1);
                if(!ch) return false;
            }
        }
        return true;
    }
}