class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> num=new ArrayList<>();
        for(String s:nums){
            num.add(s);
        }
        return backtrack(num,"",nums.length);
    }
    public static String backtrack(List<String> num,String curr,int n){
        if(curr.length()==n){
            if(!num.contains(curr)){
                return curr;
            }else{
                return "";
            }
           
        }
        String result="";
        for(char c:new char[]{'0','1'}){
            String res= backtrack(num,curr+c,n);
            if(res.length()>0){
                result=res;
                break;
            }
        }
        return result;
    }
}