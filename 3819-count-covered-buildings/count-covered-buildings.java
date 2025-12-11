class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        // Group by row and col
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMap.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            colMap.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

       
        for (List<Integer> list : rowMap.values()) Collections.sort(list);
        for (List<Integer> list : colMap.values()) Collections.sort(list);

        int count = 0;

        // Check every building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> ys = rowMap.get(x);
            List<Integer> xs = colMap.get(y);

            
            if (ys.size() < 3 || xs.size() < 3) continue;

            int minY = ys.get(0), maxY = ys.get(ys.size() - 1);
            int minX = xs.get(0), maxX = xs.get(xs.size() - 1);

            if (minY < y && y < maxY && minX < x && x < maxX)
                count++;
        }

        return count;
    }
}
