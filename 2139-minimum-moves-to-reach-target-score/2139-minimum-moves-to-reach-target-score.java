class Solution {
    public int minMoves(int tar, int maxDoubles) {
        int opr = 0, st = 1;
        while(tar > st && maxDoubles > 0){
            opr++;
            if(tar % 2 == 1) tar -= 1;
            else if(tar % 2 == 0 && maxDoubles > 0){
                tar = tar / 2;
                maxDoubles--;
            }else{
                tar -= 1;
            }
        }
        return opr + tar - st;
    }
}