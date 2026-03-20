import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                ans[i][j] = findMinAbsDiff(grid, i, j, k);
            }
        }
        
        return ans;
    }
    
    private int findMinAbsDiff(int[][] grid, int row, int col, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = row; i < row + k; i++) {
            for (int j = col; j < col + k; j++) {
                set.add(grid[i][j]);
            }
        }
        
        if (set.size() <= 1) return 0;
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
        }
        
        return minDiff;
    }
}