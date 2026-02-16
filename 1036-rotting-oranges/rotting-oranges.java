import java.util.*;

class Solution {
    
    class Pair {
        int row;
        int col;
        int time;
        
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        
        int fresh = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));  
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int time = 0;
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        //  BFS
        while(!q.isEmpty()) {
            
            Pair front = q.remove();
            
            int r = front.row;
            int c = front.col;
            int t = front.time;
            
            time = Math.max(time, t);
            
            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n
                        && !vis[nr][nc] && grid[nr][nc] == 1) {
                    
                    vis[nr][nc] = true;
                    fresh--;
                    
                    q.add(new Pair(nr, nc, t + 1));
                }
            }
        }
        
        if(fresh > 0) return -1;
        
        return time;
    }
}
