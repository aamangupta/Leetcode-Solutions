class Solution {
    
    // same as #785 is bipartite , but the diff is:
    // we have to make a graph in this ques and rest the same.
    
    public boolean helper(int colors[], ArrayList<Integer>[] graph, int src, int color){
        if(colors[src] != 0) {
            return colors[src] == color;
        }        
        
        colors[src] = color;
        for(int i : graph[src]){
            boolean ch = helper(colors, graph, i, -color);
            if(!ch) return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int n1 = dislikes.length, colors[] = new int[n + 1];
        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n1; i++){
            int u = dislikes[i][0], v = dislikes[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 1; i <= n; i++){
            if(colors[i] == 0) {
                boolean check = helper(colors, graph, i, 1);
                if(!check) return false;
            }
        }
        return true;
    }
}