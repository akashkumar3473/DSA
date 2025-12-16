class Solution {
     static void queen(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(makeString(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                queen(board,row+1,ans);
                board[row][col]='.';
            }
        }

    }
    static boolean isSafe(char[][] board,int row,int col){
        // check column
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        // check left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        // check right diagonal
        for(int i=row-1,j=col+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    static List<String> makeString(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        queen(board, 0, ans);
        return ans;
    }
}