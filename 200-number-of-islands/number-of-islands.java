class Solution {

    class Pair{
        int row;
        int col;
    }
    int r[] = {1,0,-1,0};
    int c[] = {0,1,0,-1};

    void bfs(char[][] grid, boolean isVis[][], int x, int y, int totalRows, int totalCols){
         Queue<Pair> q = new LinkedList<>();
         Pair p = new Pair();
         p.row = x;
         p.col = y;

         q.add(p);
         isVis[x][y] = true;

         while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;

            for(int i=0;i<4;i++){
                int newCurrRow = currRow +r[i]; 
                int newCurrCol= currCol +c[i]; 

                if(check(newCurrRow, newCurrCol, totalRows, totalCols) &&
                   !isVis[newCurrRow][newCurrCol] &&
                   grid[newCurrRow][newCurrCol] == '1'){
                    isVis[newCurrRow][newCurrCol]=true;
                    Pair temp = new Pair();
                    temp.row = newCurrRow;
                    temp.col = newCurrCol;
                    q.add(temp);

                }
                
            }
            
         }

    }
    boolean check(int row,int col,int n, int m){
        if(row>=0 && row<n && col>=0 && col<m) return true;
        return false;
    }
    public int numIslands(char[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;
        boolean isVis[][] = new boolean[n][m];

        int count =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isVis[i][j]==false && grid[i][j]=='1'){
                    count++;
                    bfs(grid,isVis,i,j,n,m);
                }
            }
        }
        return count;
    }
}
