class Solution {

    class DSU{
        int[] parent;

        DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px!=py) parent[py] = px;
        }

        void reset(int x){
            parent[x] = x;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings,(a,b)->a[2]-b[2]);

        DSU dsu = new DSU(n);

        dsu.union(0,firstPerson);

        int i=0;

        while(i < meetings.length){

            int time = meetings[i][2];

            List<Integer> people = new ArrayList<>();

            int j = i;

            while(j < meetings.length && meetings[j][2] == time){

                int x = meetings[j][0];
                int y = meetings[j][1];

                dsu.union(x,y);

                people.add(x);
                people.add(y);

                j++;
            }

            for(int p : people){
                if(dsu.find(p) != dsu.find(0)){
                    dsu.reset(p);
                }
            }

            i = j;
        }

        List<Integer> ans = new ArrayList<>();

        for(int k=0;k<n;k++){
            if(dsu.find(k) == dsu.find(0)){
                ans.add(k);
            }
        }

        return ans;
    }
}