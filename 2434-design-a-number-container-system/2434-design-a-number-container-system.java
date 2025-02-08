class NumberContainers {
    public HashMap<Integer,TreeSet<Integer>> num;
    public HashMap<Integer,Integer> idx;
    public NumberContainers() {
        num=new HashMap<>();
        idx=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idx.containsKey(index)){
            int prev=idx.get(index);
            num.get(prev).remove(index);
            if(num.get(prev).isEmpty()){
                num.remove(prev);
            }
        }
        idx.put(index,number);
        num.putIfAbsent(number,new TreeSet<>());
        num.get(number).add(index);
    }
    
    public int find(int number) {
        if(num.containsKey(number) && !num.get(number).isEmpty()){
            return num.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */