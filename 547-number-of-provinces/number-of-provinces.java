class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }
    private void dfs(int city, int[][] isConnected, boolean[] visited){
         visited[city] = true;
         for (int j = 0; j < isConnected.length; j++) {

            if (isConnected[city][j] == 1 && !visited[j]) {

                dfs(j, isConnected, visited);
            }
        }
    }
}
