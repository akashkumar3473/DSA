
class Solution {

    class Pair {
        int row;
        int col;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int n;
        int m;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isValid(int r, int c, int n, int m) {
            return (r >= 0 && r < n && c >= 0 && c < m);
        }

        public int bfs(int[][] grid, boolean[][] isVisited, int i, int j) {

            n = grid.length;
            m = grid[0].length;

            Queue<Pair> q = new LinkedList<>();

            isVisited[i][j] = true;
            q.add(new Pair(i, j));

            int ans = 0;

            while (!q.isEmpty()) {

                Pair p = q.poll();
                int row = p.row;
                int col = p.col;

                ans += 4;

                for (int k = 0; k < 4; k++) {
                    int adjrow = row + dx[k];
                    int adjcol = col + dy[k];

                    if (isValid(adjrow, adjcol, n, m) 
                            && grid[adjrow][adjcol] == 1) {
                        ans--;
                    }

                    if (isValid(adjrow, adjcol, n, m)
                            && grid[adjrow][adjcol] == 1
                            && !isVisited[adjrow][adjcol]) {

                        isVisited[adjrow][adjcol] = true;
                        q.add(new Pair(adjrow, adjcol));
                    }
                }
            }
            return ans;
        }
    }
    public int islandPerimeter(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] isVisited = new boolean[n][m];

        Pair obj = new Pair(0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    return obj.bfs(grid, isVisited, i, j);
                }
            }
        }
        return 0;
    }
}