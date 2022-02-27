class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0, hi = 100000000000000L;
        while(lo < hi){
            long mid = lo + (hi - lo) / 2;
            long countTrips = 0;
            for(int i : time){
                countTrips += (mid / i);
            }
            if(countTrips >= totalTrips) hi = mid;
            else if(countTrips < totalTrips) lo = mid + 1;
        }
        return lo;
    }
}