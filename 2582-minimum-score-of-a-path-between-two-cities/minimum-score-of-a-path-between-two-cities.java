class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minScore(int n, int[][] arr) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());
        for(int[] e : arr){
            int u = e[0];
            int v = e[1];
            int dist = e[2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        Queue<Pair> q = new LinkedList<>();
        boolean vis[] = new boolean[n+1];
        q.add(new Pair(1,Integer.MAX_VALUE));
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p =q.remove();
            //if(vis[p.node]) continue;
            vis[p.node]= true;
            ans = Math.min(ans,p.dist);
            for(Pair adjcomp : adj.get(p.node)){
                if(!vis[adjcomp.node]){
                    q.add(adjcomp);
                }
            }
        }
        return ans;
    }
}