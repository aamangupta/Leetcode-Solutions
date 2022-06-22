class Solution {
    
    // the idea is using using bricks and then if more diff. is there then using ladder
    // decreasing diff from bricks and also storing the diff in priorityqueue
    // whenever bricks < 0
    // brick += pq.remove();
    //    then chekcing if ladder exist 
            // if yes, then dec. ladder
            // else return ans
    
    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = 0, i = 1, n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        while(i < n){
            if(heights[i] <= heights[i - 1]){
                ans++;
            }else{
                int reqHeight = heights[i] - heights[i - 1];
                bricks -= reqHeight;
                pq.add(reqHeight);
                
                if(bricks < 0){
                    bricks += pq.remove();
                    if(ladders >= 1){
                        ladders--;
                        ans++;    
                    } 
                    else return ans;
                }else ans++;
            }
            i++;
        }
        return --i;
    }
}