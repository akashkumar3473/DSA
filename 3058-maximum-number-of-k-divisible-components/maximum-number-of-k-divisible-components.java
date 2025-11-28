class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] ans = new int[1];
        dfs(0,-1,adj,values,k,ans);
        return ans[0];
    }
    private long dfs(int u, int parent, List<List<Integer>> adj, int[] values,int k, int[] ans){
        long sum = values[u];
        for(int v : adj.get(u)){
            if(v==parent) continue;
            sum += dfs(v, u, adj, values, k, ans);
        }
        if(sum % k==0){
            ans[0]++;
        }
        return sum;
    }
}