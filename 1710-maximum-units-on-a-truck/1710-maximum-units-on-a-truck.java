class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> {
            return b[1] - a[1];
        });
        int units = 0, count = 0;
        for(int i[] : boxTypes){
            int num = i[0], val = i[1];
            if(count < truckSize){
                while(num-- > 0 && count < truckSize){
                    units += val;
                    count++;
                }
            }else return units;
        }
        return units;
    }
}