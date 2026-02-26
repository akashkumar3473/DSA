
class Solution {

    public void dfs(List<Integer>[] graph, int node, boolean[] vis) {
        vis[node] = true;

        for (int next : graph[node]) {
            if (!vis[next]) {
                dfs(graph, next, vis);
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {

        List<Boolean> res = new ArrayList<>();


        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

  
        for (int[] edge : pre) {
            graph[edge[0]].add(edge[1]);
        }

   
        boolean[][] isReachable = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i, isReachable[i]);
        }

       
        for (int[] q : queries) {
            res.add(isReachable[q[0]][q[1]]);
        }

        return res;
    }
}