class Solution {
    public int trapRainWater(int[][] height) {
        int m = height.length;
        int n = height[0].length;

        if (m < 3 || n < 3) return 0;

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        for (int i = 0; i < m; i++){
            pq.offer(new int[]{i, 0, height[i][0]});
            pq.offer(new int[]{i, n-1, height[i][n - 1]});
            visited[i][0]=true;
            visited[i][n-1]=true;
        }
        
        for (int j = 1; j < n-1; j++){
            pq.offer(new int[]{0, j, height[0][j]});
            pq.offer(new int[]{m-1, j, height[m-1][j]});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }

        int water = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()){
            int[] cell = pq.poll();


            int r = cell[0];
            int c = cell[1];
            int h = cell[2];

            for (int k =0; k<4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0|| nr >= m || nc < 0 ||nc >=n || visited[nr][nc]){
                    continue;
                }
            visited[nr][nc] = true;

            water += Math.max(0, h - height[nr][nc]);

            pq.offer(new int[]{
                nr, nc, Math.max(h, height[nr][nc])
            });

            }
        }

        return water;
    }
}