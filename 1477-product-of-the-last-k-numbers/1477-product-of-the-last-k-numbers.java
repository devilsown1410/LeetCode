class ProductOfNumbers {
    public List<Integer> ll;
    public int prod;
    public ProductOfNumbers() {
        ll=new ArrayList<>();
        prod=1;
    }
    
    public void add(int num) {
        if(num==0){
            ll=new ArrayList<>();
            prod=1;
            return;
        }
        prod*=num;
        ll.add(prod);
    }
    
    public int getProduct(int k) {
        if(ll.size()<k) return 0;
        int ans=ll.get(ll.size()-1);
        if(ll.size()==k) return ans;
        return ans/ll.get(ll.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */