class Solution {
    public int minOperations(int[][] grid, int x) {
        int res[]=new int[grid.length*grid[0].length];
        int id=0;
        for(int i[]:grid){
            for(int j=0;j<i.length;++j){
                res[id++]=i[j];
            }
        }
        Arrays.sort(res);
        int med=res[res.length/2];
        int cost=0;
        for(int i:res){
            int diff=Math.abs(i-med);
            if(diff%x!=0){
                return -1;
            }
            cost+=(diff)/x;
        }
        return cost;
    }
}