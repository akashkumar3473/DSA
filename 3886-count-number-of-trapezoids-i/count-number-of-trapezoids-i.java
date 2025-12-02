class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;

        long ans  = 0;
        long totaledges = 0;
        for(int point[] : points){
            map.put(point[1], map.getOrDefault(point[1],0)+1);
        } // [0--> 3], [2--> 2]
        for(int num : map.values()){
            long edges = ((long)num*(num-1))/2;
            ans = (ans + totaledges * edges)%mod; 
            totaledges = (totaledges + edges)%mod;
        }
        return (int)ans;
    }
}