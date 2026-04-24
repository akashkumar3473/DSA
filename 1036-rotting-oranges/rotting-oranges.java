class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for (int i=0;i<grid.length;i++) for (int j=0;j<grid[0].length;j++) {
            if (grid[i][j]==2) q.offer(new int[]{i,j});
            else if (grid[i][j]==1) fresh++;
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty() && fresh>0) {
            int sz = q.size(); time++;
            for (int k=0;k<sz;k++) {
                int[] cur = q.poll();
                for (int[] d:dirs) {
                    int ni=cur[0]+d[0], nj=cur[1]+d[1];
                    if (ni>=0&&nj>=0&&ni<grid.length&&nj<grid[0].length&&grid[ni][nj]==1) {
                        grid[ni][nj]=2; fresh--; q.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return fresh==0 ? time : -1;

    }
}