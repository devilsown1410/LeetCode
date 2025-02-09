class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        long res=(n*(n-1))/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        long sum=0;
        for(int i=0;i<nums.length;++i){
            int key=i-nums[i];
            sum+=map.getOrDefault(key,0);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return res-sum;
    }
}