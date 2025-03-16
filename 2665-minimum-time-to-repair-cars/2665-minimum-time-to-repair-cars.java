class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left=0,right=Long.MAX_VALUE;
        while(left<right){
            long mid=left+(right-left)/2;
            if(check(ranks,mid,cars)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean check(int ranks[],long mid,int cars){
        long sum=0;
        for(int rank:ranks){
            sum+=Math.sqrt(mid/rank);
        }
        return cars<=sum;
    }
}