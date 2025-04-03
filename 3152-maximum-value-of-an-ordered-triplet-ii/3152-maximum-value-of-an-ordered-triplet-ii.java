class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int front[]=new int[n];
        front[0]=0;
        for(int i=1;i<n;++i){
            front[i]=Math.max(front[i-1],nums[i-1]);
        }
        int back[]=new int[n];
        back[n-1]=0;
        for(int i=n-2;i>=0;--i){
            back[i]=Math.max(back[i+1],nums[i+1]);
        }
        
        long res=0;
        for(int i=0;i<n;++i){
            res=Math.max((long)(front[i]-nums[i])*back[i],res);
        }
        return res;
    }
}