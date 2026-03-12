//import java.util.*;

class Solution {
    static int[] parent;
    static int[] size;

    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(size[a] > size[b]){
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);

        int q = queries.length;
        int[][] q2 = new int[q][4];

        for(int i=0;i<q;i++){
            q2[i][0] = queries[i][0];
            q2[i][1] = queries[i][1];
            q2[i][2] = queries[i][2];
            q2[i][3] = i;
        }

        Arrays.sort(q2, (a,b) -> a[2] - b[2]);

        boolean[] ans = new boolean[q];
        int i = 0;

        for(int[] query : q2){

            int u = query[0];
            int v = query[1];
            int limit = query[2];
            int idx = query[3];

            while(i < edgeList.length && edgeList[i][2] < limit){
                union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            ans[idx] = find(u) == find(v);
        }

        return ans;
    }
}