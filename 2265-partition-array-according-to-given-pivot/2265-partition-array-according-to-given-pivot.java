class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int res[]=new int[nums.length];
        int left=0,right=nums.length-1;
        for(int i=0,j=nums.length-1;i<nums.length;i++,j--){
            if(nums[i]<pivot){
                res[left++]=nums[i];
            }if(nums[j]>pivot){
                res[right--]=nums[j];
            }
        }
        while(left<=right){
            res[left++]=pivot;
        }
        return res;
    }
}