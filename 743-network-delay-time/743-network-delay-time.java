class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for(int i = 0; i < times.length; i++){
            int u = times[i][0], v = times[i][1], w = times[i][2];
            graph.get(u).add(new int[]{v, w});
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        q.add(new int[]{k, 0});
        int time = 0;
        boolean []vis = new boolean[n + 1];
        vis[0] = true;
        while(q.size() > 0){
            int[] rem = q.poll();
            if(vis[rem[0]]) continue;
            time = rem[1];
            vis[rem[0]] = true;
            for(int i[] : graph.get(rem[0])){
                int u = i[0];
                int w = i[1];
                if(vis[u] == false){
                    q.offer(new int[]{u, rem[1] + w});
                }
            }
        }
        for(boolean i : vis) {
            if(i == false) return -1;
        }
        return time;
    }
}