class Solution {
    // sorting array acc. to the no. of units in desc. order
    // now incrementing the count of trucks and units acc to the condition
    // prefering more no. of trucks from starting of arr.
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // b[1] - a[1] may cause int overflow, credit to @Zudas.
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        
        int units = 0, count = 0;
        for(int i[] : boxTypes){
            int num = i[0], val = i[1];
            if(truckSize >= num){
                truckSize -= num;
                units += num * val;
            }else{
                units += truckSize * val;
                return units;
            }
        }
        return units;
    }
}