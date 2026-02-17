class Solution {
    private void dfs(int room,boolean[] vis,List<List<Integer>> adj){
            
            vis[room]=true;
            for(int key : adj.get(room)){
                if(!vis[key]){
                    dfs(key,vis,adj);
                }
            }
        
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis  = new boolean[n];
        vis[0]=true;
        dfs(0,vis,adj);
        for(boolean ele : vis){
            if(ele==false) return false;
        }
        return true;
    }
}