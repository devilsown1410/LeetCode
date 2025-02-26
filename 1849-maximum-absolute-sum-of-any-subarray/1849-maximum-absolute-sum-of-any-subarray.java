class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=0;
        int minsum=0;
        int currmax=0;
        int currmin=0;
        for(int i:nums){
            currmax=Math.max(i,currmax+i);
            maxsum=Math.max(maxsum,currmax);
            currmin=Math.min(i,currmin+i);
            minsum=Math.min(minsum,currmin);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}