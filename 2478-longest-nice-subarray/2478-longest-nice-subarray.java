class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res=0;
        int start=0;
        int curr=0;
        for(int i=0;i<nums.length;++i){
            while((curr&nums[i])!=0){
                curr^=nums[start];
                start++;
            }
            curr|=nums[i];
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}