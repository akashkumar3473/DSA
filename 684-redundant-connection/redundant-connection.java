class Solution {
    static int[] parent;
    static int[] size;
    int find(int u){
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }
    void union(int u,int v){
        int a = find(u);
        int b = find(v);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] = a;
                size[a] += size[b];

            }
            parent[a]=b;
            size[b]=size[a];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0; i<=n;i++){
            parent[i]=i;
            size[i] = 1;
        }
        int[] ans = new int[2];
        for(int[] arr : edges){
            int u = arr[0], v = arr[1];
            if(find(u)==find(v)){
                ans[0] = u ;ans[1] = v ; break;
            }
            union(u,v);
        }
        return ans;

    }
}