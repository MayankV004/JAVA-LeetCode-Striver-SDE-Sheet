class Solution {
    public int[] constructST(int heights[]){
        int n = heights.length;
        int segmentTree[] = new int[4*n];
        buildTree(0 , 0 , n-1 , segmentTree , heights);
        return segmentTree;
    }
    private void buildTree(int node , int l , int r , int []ST , int arr[]){
        if(l == r){
            ST[node] = l;
            return ;
        }

        int mid = l + (r-l)/2;
        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;
                
        buildTree(leftChild , l , mid , ST , arr);
        buildTree(rightChild , mid+1 , r , ST , arr);

        int leftIdx = ST[leftChild];
        int rightIdx = ST[rightChild];

        ST[node] = (arr[leftIdx] >= arr[rightIdx]) ? leftIdx : rightIdx;
        
    }
    public int RMIQ(int ST[] , int heights[] , int l , int r){
        return querySegmentTree(0 , 0 , heights.length -1 , ST , heights , l , r);
    }

    private int querySegmentTree(int node , int l , int r , int ST[] ,int[] heights ,int start , int end){
        // no overlap
        if(r < start || l > end) return -1;

        // complete Overlap
        if(start <= l && r <= end){
            return ST[node];
        }

        int mid = l + (r-l)/2;
        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;

        int leftIdx = querySegmentTree(leftChild , l , mid , ST , heights , start , end);
        int rightIdx = querySegmentTree(rightChild , mid + 1 , r , ST , heights ,  start , end);

        if(leftIdx == -1) return rightIdx;
        if(rightIdx == -1) return leftIdx;

        return (heights[leftIdx] >= heights[rightIdx]) ? leftIdx : rightIdx;
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int ST [] = constructST(heights);
        int n = heights.length;
        int []result = new int[queries.length];

        for(int q = 0 ; q < queries.length ; q++){
            int []query = queries[q];
            int start = query[0];
            int end = query[1];

            int maxIdx = Math.max(start , end);
            int minIdx = Math.min(start , end);

            if(minIdx == maxIdx){
                result[q] = maxIdx;
                continue;
            }else if(heights[maxIdx] > heights[minIdx]){
                result[q] = maxIdx;
                continue; 
            }

            int l = maxIdx + 1;
            int r = n-1;
            int resIdx = Integer.MAX_VALUE;

            while(l <= r){
                int mid = l + (r-l)/2;

                int idx = RMIQ(ST , heights , l , mid);

                if(heights[idx] > Math.max(heights[start] , heights[end])){
                    resIdx = Math.min(resIdx , idx);
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }

            }

            if(resIdx == Integer.MAX_VALUE){
                result[q] = -1;
            }else{
                result[q] = resIdx;
            }
        }

        return result;
    }
}