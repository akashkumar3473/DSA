import java.util.*;

class Solution {
    class Node{
        int time, r, c, step;

        Node(int time,int r,int c,int step){
            this.time = time;
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }

    public int minTimeToReach(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][][] dist = new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.time-b.time);

        dist[0][0][0] = 0;
        pq.add(new Node(0,0,0,0));

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int time = cur.time;
            int r = cur.r;
            int c = cur.c;
            int step = cur.step;

            if(time > dist[r][c][step%2]) continue;

            if(r == n-1 && c == m-1) return time;

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                int moveCost = (step % 2 == 0) ? 1 : 2;
                int arrival = Math.max(time, arr[nr][nc]) + moveCost;

                int nextStep = step + 1;

                if(arrival < dist[nr][nc][nextStep%2]){
                    dist[nr][nc][nextStep%2] = arrival;
                    pq.add(new Node(arrival, nr, nc, nextStep));
                }
            }
        }

        return -1;
    }
}