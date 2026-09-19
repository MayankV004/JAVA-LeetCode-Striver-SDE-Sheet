class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int segmentTree[] = new int[4*n];
        buildSegmentTree(0 , 0 , n-1 , baskets, segmentTree);
        int unplaced = 0;
        for(int i = 0 ; i < n ; i++){
            if(!querySegmentTree(0 , 0 , n-1 , fruits[i] , segmentTree)){
                unplaced++;
            }
        }

        return unplaced;

 
    }

    private void buildSegmentTree(int node , int l , int r , int baskets [] , int []segmentTree){
        if(l == r){
            segmentTree[node] = baskets[l];
            return;
        }

        int mid = l + (r-l)/2;

        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;

        buildSegmentTree(leftChild , l , mid , baskets , segmentTree);
        buildSegmentTree(rightChild , mid+1 , r , baskets , segmentTree);

        segmentTree[node] = Math.max(segmentTree[leftChild] , segmentTree[rightChild]);
    }
    
    public boolean querySegmentTree(int node , int l , int r , int val , int segmentTree[]){
        if(segmentTree[node] < val){
            return false;
        }

        if(l == r){
            segmentTree[node] = -1;
            return true;
        }
        boolean placed = false;
        int mid = l + (r-l)/2;
        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;

        if(segmentTree[leftChild] >= val){
            placed = querySegmentTree(leftChild , l , mid , val , segmentTree);
        }else{
            placed = querySegmentTree(rightChild , mid+1 , r , val , segmentTree);
        }

        segmentTree[node] = Math.max(segmentTree[leftChild] , segmentTree[rightChild]);

        return placed;
    }

}