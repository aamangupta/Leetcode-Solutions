class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = 0, i = 1, n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        while(i < n){
            if(heights[i] <= heights[i - 1]){
                i++;
                ans++;
            }else{
                int reqHeight = heights[i] - heights[i - 1];
                bricks -= reqHeight;
                pq.add(reqHeight);
                ans++;
                i++;
                if(bricks < 0){
                    bricks += pq.remove();
                    if(ladders >= 1) ladders--;
                    else return --ans;
                }
            }
        }
        return --i;
    }
}