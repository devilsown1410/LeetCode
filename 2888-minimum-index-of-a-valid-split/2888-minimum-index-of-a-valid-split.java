class Solution {
    public int minimumIndex(List<Integer> nums) {
        int cand=-1,cnt=0;
        for(int i:nums){
            if(cnt==0){
                cand=i;
                cnt=1;
            }else if(cand==i){
                cnt++;
            }else{
                cnt--;
            }
        }
        cnt=0;
        for(int i:nums){
            if(cand==i){
                cnt++;
            }
        }
        int ccnt=0;
        for(int i=0;i<nums.size();++i){
            if(nums.get(i)==cand) ccnt++;
            if(ccnt*2>(i+1) && (cnt-ccnt)*2>(nums.size()-i-1)) return i;
        }
        return -1;
    }
}