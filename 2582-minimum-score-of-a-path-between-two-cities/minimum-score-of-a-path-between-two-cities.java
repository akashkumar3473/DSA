class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    List<List<Pair>> adj;
    boolean vis[];
    int ans  = Integer.MAX_VALUE;
    private void dfs(int node){
        vis[node] = true;
        for(Pair nei : adj.get(node)){
            ans = Math.min(ans,nei.dist);
            if(!vis[nei.node]){
                dfs(nei.node);
            }
        }
    }
    public int minScore(int n, int[][] arr) {
        adj = new ArrayList<>();
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());
        for(int[] e : arr){
            int u = e[0];
            int v = e[1];
            int dist = e[2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        vis=new boolean[n+1];
        dfs(1);
        return ans;
    }
}