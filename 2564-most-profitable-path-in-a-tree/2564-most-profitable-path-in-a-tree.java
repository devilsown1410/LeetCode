class Solution {
    public int maxProfit=Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int timer=1;
        int n=amount.length;
        int[] time=new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        List<List<Integer>> ll=new ArrayList<>();
        for(int i=0;i<n;++i){
            ll.add(new ArrayList<>());
        }
        for(int i[]:edges){
            ll.get(i[0]).add(i[1]); 
            ll.get(i[1]).add(i[0]); 
        }
        bobtraversal(ll,time,bob,-1,timer);
        timer=1;
        alicetraversal(ll,time,amount,0,-1,0,timer);
        return maxProfit;
    }
    public boolean bobtraversal(List<List<Integer>> ll,int time[],int root,int parent,int timer){
        time[root]=timer++;
        if(root==0) return true;
        for(int nbr:ll.get(root)){
            if(nbr!=parent){
                if(bobtraversal(ll,time,nbr,root,timer)){
                    return true;
                }
            }
        }
        time[root]=Integer.MAX_VALUE;
        return false;
    }
    public void alicetraversal(List<List<Integer>> ll,int time[],int amount[],int root,int parent,int curr,int alicetime){
        if(time[root]>alicetime){
            curr+=amount[root];
        }else if(time[root]==alicetime){
            curr+=(amount[root]/2);
        }
        alicetime++;
        if(ll.get(root).size()==1 && ll.get(root).get(0)==parent){
            maxProfit=Math.max(maxProfit,curr);
            return;
        }
        for(int nbr:ll.get(root)){
            if(nbr!=parent){
                alicetraversal(ll,time,amount,nbr,root,curr,alicetime);
            }
        }
        return;
    }
}