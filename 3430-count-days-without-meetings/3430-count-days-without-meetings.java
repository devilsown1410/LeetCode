class Solution {
    public int countDays(int days, int[][] meetings) {
        int res=0;
        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        int s=meetings[0][0];
        int e=meetings[0][1];
        for(int i=1;i<meetings.length;++i){
            if(meetings[i][0]<=e+1){
                e= Math.max(e,meetings[i][1]);
            }
            else{
                res+=e-s+1;
                s=meetings[i][0];
                e=meetings[i][1];
            }
        }
        res+=e-s+1;
        return days-res;
    }
}