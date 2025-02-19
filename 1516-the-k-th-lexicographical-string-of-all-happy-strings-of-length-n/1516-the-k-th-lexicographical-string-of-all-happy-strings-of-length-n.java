class Solution {
    public String getHappyString(int n, int k) {
        List<String> res=new ArrayList<>();
        check("",n,res);
        return res.size()>=k ? res.get(k-1):"";
    }
    public void check(String curr,int n,List<String> res){
        if(curr.length()==n){
            res.add(curr);
            return;
        }
        for(char c:new char[]{'a','b','c'}){
            if(curr.isEmpty() || curr.charAt(curr.length()-1)!=c){
                check(curr+c,n,res);
            }
        }
    }
}
