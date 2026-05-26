class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        if(n == 1 && arr[0] == 0) return true;
        
        Queue<Integer> q = new ArrayDeque<>();
        int visited[] = new int[n];
        
        q.offer(start);
        visited[start] = 1;
        while(!q.isEmpty()){
            int idx = q.poll();
            if(arr[idx] == 0) return true;
            int posIdx = idx + arr[idx];
            int negIdx = idx - arr[idx];

            if(posIdx < n && visited[posIdx] == 0){
                if(arr[posIdx] == 0) return true;
                q.offer(posIdx);
                visited[posIdx] = 1;
            }

            if(negIdx >= 0 && visited[negIdx] == 0){
                if(arr[negIdx] == 0) return true;
                q.offer(negIdx);
                visited[negIdx] = 1;
            }

        }

        return false;
    }
}