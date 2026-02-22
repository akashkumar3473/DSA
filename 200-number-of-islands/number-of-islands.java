class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    int n;
    int m;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};
    public boolean isValid(int r, int c, int n, int m){

        if(r>=0 && r<n && c>=0 && c<m) return true;
        return false;
    }
    public void bfs(char[][] grid,boolean[][] isVisited,int r,int c){
        isVisited[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i=p.row;
            int j =p.col;
            for(int k=0;k<4;k++){
                int adjrow = i + dx[k];
                int adjcol = j + dy[k];
                if(isValid(adjrow,adjcol,n,m)
                && grid[adjrow][adjcol]=='1'
                && !isVisited[adjrow][adjcol]){
                    
                    isVisited[adjrow][adjcol]=true;
                    q.add(new Pair(adjrow,adjcol));
                }
                
            }
        }
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count =0;
        boolean[][] isVisited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && isVisited[i][j]==false){
                    bfs(grid,isVisited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}