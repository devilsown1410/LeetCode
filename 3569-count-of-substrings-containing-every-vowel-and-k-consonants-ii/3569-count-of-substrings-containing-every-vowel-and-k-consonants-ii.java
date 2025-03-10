class Solution {
    public long countOfSubstrings(String word, int k) {
        return check(word,k)-check(word,k+1);
    }
    public static long check(String word,int k){
        long res=0;
        int left=0;
        int cons=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<word.length();++right){
            char ch=word.charAt(right);
            if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u'){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }else{
                cons++;
            }
            while(map.size()==5 && cons>=k){
                res+=word.length()-right;
                char c=word.charAt(left);
                if(c=='a' || c=='e'|| c=='i' || c=='o' || c=='u'){
                    map.put(c,map.getOrDefault(c,0)-1);
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                }else{
                    cons--;
                }
                left++;
            }
            
        }
        return res;
    }
}