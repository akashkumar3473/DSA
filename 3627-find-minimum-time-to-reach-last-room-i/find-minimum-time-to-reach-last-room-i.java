class Solution {
    class Node{
        int time, r,c;
        Node(int time,int r,int c){
            this.time = time;
            this.r = r;
            this.c = c;
        }
    }
    public int minTimeToReach(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        int[][] dist = new int[n][m];
        for(int[] row : dist) Arrays.fill(row,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.time - b.time);
        dist[0][0]=0;
        pq.add(new Node(0,0,0));

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int time = cur.time;
            int r = cur.r;
            int c = cur.c;

            if(time > dist[r][c]) continue;

            if(r==n-1 && c== m-1) return time;

            for(int i=0;i<4;i++){
                int nr = r+dx[i];
                int nc = c+dy[i];

                if(nr>=n || nr<0 || nc>=m || nc<0) continue;

                int arrival = Math.max(time,arr[nr][nc]) + 1;
                if(arrival < dist[nr][nc]){
                    dist[nr][nc] = arrival;
                    pq.add(new Node(arrival,nr,nc));
                }
            }
        }
        return -1;
    }
}