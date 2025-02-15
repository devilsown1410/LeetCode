class Solution {
    public int punishmentNumber(int n) {
        int res=1;
        for(int i=2;i<=n;++i){
            if(pos(i*i,i)){
                res+=(i*i);
            }
        }
        return res;
    }
    public boolean pos(int num,int t){
        if(t<0 || num<t) return false;
        if(num==t) return true;
        return pos(num/10,t-num%10) || pos(num/100,t-num%100) || pos(num/1000,t-num%1000);
    }
}