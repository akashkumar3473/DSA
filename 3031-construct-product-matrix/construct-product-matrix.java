class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int N = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        long pref = 1, suf = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = (int) pref;
                pref = (pref*grid[i][j]) % N;
            }
        }
        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                ans[i][j] = (int) ((ans[i][j] * suf) % N);
                suf = (suf*grid[i][j])%N;
            }
        }
        return ans;
    }
}