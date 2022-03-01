class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long st=0,end=(long)1e14;
        long ans=end;
        while(st<=end){
            long mid=st+(end-st)/2;
            if(find(time,mid,totalTrips)>=totalTrips){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        
        return ans;
    }
    
    public long find(int[] time,long v,long totalTrips){
        long sum=0;
        for(int i=0;i<time.length;i++){
            sum+=v/time[i];
        }
        return sum;
    }
}