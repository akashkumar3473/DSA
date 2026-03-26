import java.util.*;

class Solution {

    public class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public class Triplet  {
        int node;
        int cost;
        int stops;

        Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops; 
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < flights.length; i++) { 
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            adj.get(from).add(new Pair(to, price));
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        Queue<Triplet> pq = new LinkedList<>();
        pq.add(new Triplet(src, 0, 0));

        while (!pq.isEmpty()) {
            Triplet top = pq.poll();
            int node = top.node;
            int cost = top.cost;
            int stops = top.stops;
            
            if (stops > k) continue;

            for (Pair p : adj.get(node)) {
                int totalCost = cost + p.cost;

                if (totalCost < ans[p.node]) {
                    ans[p.node] = totalCost; 
                    pq.add(new Triplet(p.node, totalCost, stops + 1));
                }
            }
        }

        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
}