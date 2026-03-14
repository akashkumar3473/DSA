class Solution {
    static int[] parent;
    static int[] size;
    int leader( int a){
        if(parent[a]==a) return a;
        return parent[a] = leader(parent[a]);
    }
    void union(int a,int b){
        a = leader(a);
        b = leader(b);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b]=a;
                size[a] -= size[b];
            }
            else{
                parent[a]=b;
                size[b]+=a;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new  int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int[] ans = new int[2];
        for(int[] arr:edges){
            int a = arr[0] , b = arr[1];
            if(leader(a)==leader(b)){
                ans[0] = a; ans[1]=b; break;
            }
            else union (a,b);
        }
        return ans;
    }
}