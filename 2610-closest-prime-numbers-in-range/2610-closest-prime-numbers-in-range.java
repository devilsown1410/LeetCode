class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean prime[]=new boolean[right+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i=2;i*i<=right;++i){
            if(prime[i]==true){
                for(int j=i*i;j<=right;j+=i){
                    prime[j]=false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }
        int res=Integer.MAX_VALUE;
        int result[]={-1,-1};
        for(int i=1;i<primes.size();++i){
            int gap=primes.get(i)-primes.get(i-1);
            if(gap<res){
                res=gap;
                result[0]=primes.get(i-1);
                result[1]=primes.get(i);
            }
        }
        return result;
    }
}