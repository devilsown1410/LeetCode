class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int xor=0;
        Set<Integer> st=new HashSet<>();
        int n=grid.length;
        int total=(n*n*(n*n+1)/2);
        int s=0,repeat=0;
        for(int i[]:grid){
            for(int j:i){
                s+=j;
                if(!st.add(j)){
                    repeat=j;
                }
            }
        }
        return new int[]{repeat,total-(s-repeat)};
    }
}