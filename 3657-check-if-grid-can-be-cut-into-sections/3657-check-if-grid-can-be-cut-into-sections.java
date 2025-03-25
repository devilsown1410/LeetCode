class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return valid(rectangles,0,0,2) || valid(rectangles,1,1,3);
    }
    public boolean valid(int rectangles[][],int sort,int start,int end){
        Arrays.sort(rectangles,(a,b)->{
            return a[sort]-b[sort];
        });
        int currstart=rectangles[0][start]; 
        int currend=rectangles[0][end]; 
        int interval=0;
        for(int i[]:rectangles){
            if(i[start]<currend){
                currend=Math.max(currend,i[end]);
            }else{
                interval++;
                currstart=i[start];
                currend=i[end];
            }
        }
        interval++;
        return interval>2;
    }
}