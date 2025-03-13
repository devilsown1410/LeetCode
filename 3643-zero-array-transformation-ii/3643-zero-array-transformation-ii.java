class Solution{
    public int minZeroArray(int[] nums, int[][] queries){
        int n = nums.length;
        int sum = 0, k = 0;
        int[] differenceArray = new int[n+1];
        for (int i=0;i<n;i++){
            while(sum + differenceArray[i] < nums[i]){
                k++;
                if(k>queries.length) 
                    return -1;
                int left = queries[k-1][0];
                int right = queries[k-1][1];
                int val = queries[k-1][2];
                if (right >= i) {
                    differenceArray[Math.max(left, i)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            sum += differenceArray[i];
        }
        return k;
    }
}