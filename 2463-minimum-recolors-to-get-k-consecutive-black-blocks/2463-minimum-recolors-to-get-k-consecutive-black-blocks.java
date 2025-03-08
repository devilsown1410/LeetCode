class Solution {
    public int minimumRecolors(String blocks, int k) {
        int res=Integer.MAX_VALUE;
        int left=0;
        int curr=0;
        int black=0;
        for(int right=0;right<blocks.length();++right){
            if(black+curr==k){
                res=Math.min(res,curr);
            }
            while(black+curr>=k){
                if(blocks.charAt(left)=='B'){
                    black--;
                }else{
                    curr--;
                }
                left++;
            }
            
            if(blocks.charAt(right)=='B') black++;
            else curr++;
        }
        if(black+curr==k){
            res=Math.min(res,curr);
        }
        return res;
    }
}