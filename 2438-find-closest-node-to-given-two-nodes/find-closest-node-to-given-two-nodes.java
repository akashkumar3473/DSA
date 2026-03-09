class Solution {
    void bfs(int src, int[] dist, int[] edge,int n){
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(q.size()>0){
            var p= q.remove();
            if(edge[p]!=-1 && dist[edge[p]]==Integer.MAX_VALUE){
                q.add(edge[p]);
                dist[edge[p]]= dist[p]+1;
            }
        }
    }
    public int closestMeetingNode(int[] edges, int n1, int n2) {
        int n = edges.length;
        int[] a = new int[n];
        int[] b = new int[n];

        Arrays.fill(a,Integer.MAX_VALUE);
        Arrays.fill(b,Integer.MAX_VALUE);
        bfs(n1,a,edges,n);
        bfs(n2,b,edges,n);

        int res = Integer.MAX_VALUE,node = -1;
        for(int i=0;i<n;i++){
            if(a[i]==Integer.MAX_VALUE || b[i]==Integer.MAX_VALUE) continue;
            if(res>Math.max(a[i],b[i])){
                node = i;
                res = Math.max(a[i],b[i]);
            }

        }
        return node;
    }
}