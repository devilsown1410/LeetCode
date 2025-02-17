class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> st=new HashSet<>();
        boolean[] used=new boolean[tiles.length()];
        backtrack(tiles,"",st,used);
        return st.size();
    }
    public static void backtrack(String tiles,String curr,Set<String> st,boolean[] used){
        if(!curr.isEmpty()){
            st.add(curr);
        }
        for(int i=0;i<tiles.length();++i){
            if(!used[i]){
                used[i]=true;
                backtrack(tiles,curr+tiles.charAt(i),st,used);
                used[i]=false;
            }
        }
    }
}