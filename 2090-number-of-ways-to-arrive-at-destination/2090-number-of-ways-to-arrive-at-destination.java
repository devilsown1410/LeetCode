class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        List<List<int[]>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<int[]>());
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new int[] {roads[i][1], roads[i][2]});
            adj.get(roads[i][1]).add(new int[] {roads[i][0], roads[i][2]});
        }
        long[][]dist = new long[n][2];
        dist[0][1] = 1;
        for(int i=1;i<n;i++){
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = 0;
        }

        dijkstra(adj,dist, n, MOD);

        return (int)dist[n-1][1];
    }

    public static void dijkstra(List<List<int[]>>adj, long[][]dist, int n, int MOD){
        PriorityQueue<long[]>pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        pq.add(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[]temp = pq.poll();
            int node = (int)temp[1];
            long distance = temp[0];

            for(int[] i: adj.get(node)){
                long cost = i[1];
                int nghr = i[0];

                if(cost + distance < dist[nghr][0]){
                    dist[nghr][0] = cost+distance;
                    dist[nghr][1] = dist[node][1];
                    pq.add(new long[] {dist[nghr][0], nghr});
                }
                else if(cost + distance == dist[nghr][0])
                    dist[nghr][1] = (dist[nghr][1] + dist[node][1])%MOD ;
            }

        }
    }
}