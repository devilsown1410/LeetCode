class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> ll=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            int r1[]=nums1[i];
            int r2[]=nums2[j];
            if(r1[0]==r2[0]){
                ll.add(new int[]{r1[0],r1[1]+r2[1]});
                i++;
                j++;
            }else if(r1[0]>r2[0]){
                ll.add(new int[]{r2[0],r2[1]});
                j++;
            }else{
                ll.add(new int[]{r1[0],r1[1]});
                i++;
            }
        }
        while(i<nums1.length){
            ll.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while(j<nums2.length){
            ll.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        int res[][]=new int[ll.size()][2];
        for(int k=0;k<ll.size();++k){
            res[k]=ll.get(k);
        }
        return res;
    }
}