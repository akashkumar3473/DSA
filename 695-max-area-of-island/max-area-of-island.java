class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n;
    int m;

    public boolean isValid(int r, int c) {
        return (r >= 0 && r < n && c >= 0 && c < m);
    }

    public int bfs(int[][] grid, boolean[][] isVisited, int r, int c) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        isVisited[r][c] = true;

        int count = 1;   

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;

            for (int k = 0; k < 4; k++) {
                int adjrow = i + dx[k];
                int adjcol = j + dy[k];

                if (isValid(adjrow, adjcol) &&
                        grid[adjrow][adjcol] == 1 &&
                        !isVisited[adjrow][adjcol]) {

                    isVisited[adjrow][adjcol] = true;
                    q.add(new Pair(adjrow, adjcol));
                    count++;   
                }
            }
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        boolean[][] isVisited = new boolean[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    int count = bfs(grid, isVisited, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}