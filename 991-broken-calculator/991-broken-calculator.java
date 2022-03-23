class Solution {
    public int brokenCalc(int st, int tar) {
        // we are starting from the tar instead of st
        // if(tar) is odd we are making it even and then in next step we are div it by 2
        // for base cond. if(st >= tar) opr will only be to dec tar until it is eq to start
        // so reutrn st - tar;
        
        if(st >= tar) return st - tar;
        if(tar % 2 == 1) return 1 + brokenCalc(st , tar + 1);
        else return 1 + brokenCalc(st, tar / 2);
    }
}