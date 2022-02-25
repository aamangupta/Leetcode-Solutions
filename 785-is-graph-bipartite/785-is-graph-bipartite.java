class Solution {
    public class pair{
        int src;
        int lev;
        pair(int src, int lev){
            this.src = src;
            this.lev = lev;
        }
    }
    public boolean check(int src, int [][]graph, int[]vis, Queue<pair> q){
        q.add(new pair(src,0));
        while(q.size() > 0){
            pair rem = q.remove();
            int s = rem.src;
            int lev = rem.lev;
            
            if(vis[s] != -1 && vis[s] != lev) return false;
            vis[s] = lev;
            
            for(int i : graph[s]){
                if(vis[i] == -1)
                q.add(new pair(i, lev + 1));
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int []vis = new int[n];
        Arrays.fill(vis, -1);
        Queue<pair> q = new ArrayDeque<>();
        boolean ch = false;
        for(int i = 0; i < n; i++){
            if(vis[i] == -1) ch = check(i, graph, vis, q);
            if(ch == false) return false;
        }
        return true;
    }
}