class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<s1.length();++i){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        if(!(Arrays.compare(freq1,freq2)==0)) return false;
        int c=0;
        for(int i=0;i<s1.length();++i){
            if(s1.charAt(i)!=s2.charAt(i)){
                c+=1;
            }
        }
        return c==0 || c==2;
    }
}