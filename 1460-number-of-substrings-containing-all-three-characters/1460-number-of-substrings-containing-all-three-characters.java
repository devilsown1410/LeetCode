class Solution {
    public int numberOfSubstrings(String s) {
        int res=0;
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();++right){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()==3){
                res+=(s.length()-right);
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }
        return res;
    }
}