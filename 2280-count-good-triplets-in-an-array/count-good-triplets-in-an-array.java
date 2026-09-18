class Solution {
    public void updateSegmentTree(int node , int l , int r , int idx , long segmentTree[]){
        if(l == r){
            segmentTree[node] = 1;
            return ;
        }

        int mid = l + (r-l) /2;
        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;

        if(idx <= mid){
            updateSegmentTree(leftChild , l , mid , idx , segmentTree);
        }else{
            updateSegmentTree(rightChild , mid+1 , r , idx , segmentTree);
        }

        segmentTree[node] = segmentTree[leftChild] + segmentTree[rightChild];
    }
    public long querySegmentTree(int qs , int qe , int node , int l , int r ,long []segmentTree){
        if( r < qs || qe < l) return 0;

        if( qs <= l && r <= qe ) return segmentTree[node];

        int mid = l + ( r-l )/2;
        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;

        long leftSum = querySegmentTree(qs , qe , leftChild , l , mid , segmentTree);
        long rightSum = querySegmentTree(qs , qe , rightChild , mid +1 , r , segmentTree);

        return leftSum + rightSum;
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Map<Integer , Integer > map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums2[i] , i);
        }

        long []segmentTree = new long[4*n];
        long res = 0;

        updateSegmentTree(0 , 0 , n-1 , map.get(nums1[0]) , segmentTree);

        for(int i = 1 ; i < n ; i++){
            int idx = map.get(nums1[i]);
            long leftCommonCount = querySegmentTree(0 , idx , 0 , 0 , n-1, segmentTree);
            long leftUncommonCount = i - leftCommonCount;
            long elementsAfterIdxNums2 = (n-1)-idx;
            long rightCommonCount = elementsAfterIdxNums2 - leftUncommonCount;

            res += (leftCommonCount * rightCommonCount);

            updateSegmentTree(0 , 0 , n-1 , idx , segmentTree);

        }
        return res;
    }
}