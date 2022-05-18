class Solution {
    static int par[];
    static int disc[];
    static int low[];
    static int time;
    static List<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        par = new int[n];
        disc = new int[n];
        low = new int[n];
        time = 1;
        ans = new ArrayList<>();
        par[0] = -1;
        
        ArrayList< ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.size(); i++){
            int x = connections.get(i).get(0);
            int y = connections.get(i).get(1);
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        critical(0, graph);
        return ans;
        
    }
    public void critical(int src, ArrayList< ArrayList<Integer>> conn){
        disc[src] = low[src] = time;
        time++;
        
        for(int nbr : conn.get(src)){
            if(nbr == par[src]) continue;
            else if(disc[nbr] != 0){
                low[src] = Math.min(low[src], disc[nbr]);
            }else{
                par[nbr] = src;
                critical(nbr, conn);
                low[src] = Math.min(low[src], low[nbr]);
                
                if(disc[src] < low[nbr]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(src);
                    bridge.add(nbr);
                    System.out.println(src);
                    ans.add(bridge);
                }
            }
        }
    }
}