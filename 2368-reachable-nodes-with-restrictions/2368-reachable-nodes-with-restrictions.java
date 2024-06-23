class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        Set<Integer> resSet = new HashSet<Integer>();
        for (int r : restricted){
            resSet.add(r);
        }

        List<Integer>[] nodeLink = new ArrayList[n];
        for (int i = 0 ; i < n; i++) nodeLink[i] = new ArrayList<>();

        for (int[] e : edges){
            int a = e[0];
            int b = e[1];
            if (resSet.contains(a) || resSet.contains(b)) continue;
            nodeLink[a].add(b);
            nodeLink[b].add(a);
        }
        
        int count = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> que = new ArrayDeque<>();
        que.offer(0);
        visited[0] = true;

        while (!que.isEmpty()){
            int cur = que.poll();
            count++;
            for (int num : nodeLink[cur]){
                if (visited[num] || resSet.contains(num)) continue;
                que.offer(num);
                visited[num] = true;
            }
        }
        return count;
    }
}