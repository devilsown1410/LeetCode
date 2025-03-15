class Solution {
    public int minCapability(int[] nums, int k) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        if(k==1 || k==nums.length){
            return min;
        }
        int mid;
        while(min<=max){
            mid= min+(max-min)/2;
            if(check(nums,k,mid)){
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return max+1;
    }
    public boolean check(int nums[],int k,int mid){
        int last=-1;
        for(int i=0;i<nums.length && k>0;++i){
            if(nums[i]<=mid && (last==-1 || i-last>1)){
                last=i;
                k--;
            }
        }
        return k==0;
    }
}