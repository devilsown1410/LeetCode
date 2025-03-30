class Solution {
    public List<Integer> partitionLabels(String str) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int s=0;
        int e=0;
        for(int i=0;i<str.length();++i){
            mp.put(str.charAt(i),i);
        }
        List<Integer> ll=new ArrayList<>();
        for(int i=0;i<str.length();++i){
            e=Math.max(e,mp.get(str.charAt(i)));
            if(e==i){
                ll.add(e-s+1);
                s=e+1;
            }
        }
        return ll;
    }
}