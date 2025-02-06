class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;++i){
            for(int j=i+1;j<nums.length;++j){
                int prod=nums[i]*nums[j];
                mp.put(prod,mp.getOrDefault(prod,0)+1);
            }
        }
        for(int v:mp.values()){
            ans+= 4*(v)*(v-1);
        }
        return ans;
    }
}