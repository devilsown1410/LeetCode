class Solution {
    public int countCompleteComponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        createAdjList(graph,v,edges);
        boolean visited[]=new boolean[v];
        int c=0;
        for(int i=0;i<v;++i){
            if(!visited[i]){
                ArrayList<Integer> ll=bfs(graph,i,visited);
                int p=0;
                for(int j=0;j<ll.size();++j){
                    if(graph.get(ll.get(j)).size()!=ll.size()-1){
                        p=1;
                    }
                }
                if(p==0){
                    c++;
                }
            }
        }
        return c;
        
    }
    public static void createAdjList(ArrayList<ArrayList<Integer>> graph,int V,int [][] edges){
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
            
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph,int s,boolean visited[]){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ll=new ArrayList<>();
//        Add Source to Queue
        q.add(s);
        visited[s]=true;
//        Traverse while q is not empty
        int d=graph.get(s).size();
        while(!q.isEmpty()){
            int curr=q.poll();
            ll.add(curr);
            for(int i:graph.get(curr)){
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return ll;
    }
}