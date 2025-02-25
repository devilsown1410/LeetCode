class Solution {
    public int res=0;
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int even=1,odd=0,sum=0,res=0;
        for(int num:arr){
            sum+=num;
            if(sum%2==1){
                res=(res+even)%mod;
                odd++;
            }else{
                res=(res+odd)%mod;
                even++;
            }
        }
        return res;
    }
}