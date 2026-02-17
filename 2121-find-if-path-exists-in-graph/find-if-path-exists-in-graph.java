class Solution {
    private boolean dfs(int start, List<List<Integer>> adj,boolean[] vis, int end) {
        if (start == end) 
            return true;

        vis[start] = true;
        for (int ele : adj.get(start)) {
            if (!vis[ele]) {
                if(dfs(ele, adj, vis, end)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis  = new boolean[n];
        return dfs(start,adj,vis,end);
    }
}