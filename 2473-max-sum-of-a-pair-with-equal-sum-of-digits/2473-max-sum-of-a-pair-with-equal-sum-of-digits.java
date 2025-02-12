class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i:nums){
            int s=0;
            int n=i;
            while(n!=0){
                s+=n%10;
                n/=10;
            }
            if(!map.containsKey(s)){
                map.put(s,new PriorityQueue<>((a,b)->b-a));
            }
            map.get(s).add(i);
        }
        int max=-1;
        for(int i:map.keySet()){
            int sum=0;
            PriorityQueue<Integer> pq=map.get(i);
            if(pq.size()>=2){
                sum+=pq.poll();
                sum+=pq.poll();
            }
            max=Math.max(max,sum);
        }
        return max==0?-1:max;
    }
}