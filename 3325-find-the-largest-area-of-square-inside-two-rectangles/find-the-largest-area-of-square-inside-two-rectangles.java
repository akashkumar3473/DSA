class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            int x1 = bottomLeft[i][0], y1 = bottomLeft[i][1];
            int x2 = topRight[i][0], y2 = topRight[i][1];
            for (int j = i + 1; j < n; j++) {
                int x3 = bottomLeft[j][0], y3 = bottomLeft[j][1];
                int x4 = topRight[j][0], y4 = topRight[j][1];

                // compute overlap along x and y
                int w = Math.min(x2, x4) - Math.max(x1, x3);
                int h = Math.min(y2, y4) - Math.max(y1, y3);

                if (w > 0 && h > 0) {
                    long side = Math.min(w, h);
                    maxArea = Math.max(maxArea, side * side);
                }
            }
        }
        return maxArea;
    }
}
