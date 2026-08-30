class Solution {
    public boolean dfs(int node , boolean[] pathVis , boolean[] vis ,ArrayList<ArrayList<Integer>> adj ){
        vis[node] = true;
        pathVis[node] = true;
        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(dfs(adjNode , pathVis , vis , adj)) return true;
            }else if(pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        // adj lst
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int j = 0 ; j < n ; j++){
            int cource = prerequisites[j][0];
            int prerequisite = prerequisites[j][1];
            adj.get(prerequisite).add(cource);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(dfs(i , pathVis ,  vis , adj)) return false;
            }
        }
        return true;
    }
}