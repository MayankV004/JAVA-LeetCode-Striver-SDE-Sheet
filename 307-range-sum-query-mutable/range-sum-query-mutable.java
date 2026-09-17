class NumArray {
    private int []ST ;
    private int n ;
    public NumArray(int[] nums) {
        n = nums.length;
        ST = new int[4*n];
        buildTree(0 , 0 , n-1 , nums);
    }
    private void buildTree(int node , int l , int r , int[] nums){
        if(l == r){
            ST[node] = nums[r];
            return;
        }

        int mid = l + (r-l)/2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        buildTree(leftChild , l , mid , nums);
        buildTree(rightChild , mid + 1 , r , nums);

        ST[node] = ST[leftChild] + ST[rightChild];
    }
    public void update(int index, int val) {
        update(0 , 0 , n-1 , index , val);
    }
    private void update(int node , int l , int r , int idx , int val){
        if(l == r){
            ST[node] = val;
            return ;
        }

        int mid = l + (r-l)/2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        if(idx <= mid){
            update(leftChild , l , mid , idx , val);
        }else{
            update(rightChild , mid + 1 , r , idx , val);
        }

        ST[node] = ST[leftChild] + ST[rightChild];
    }
    public int sumRange(int left, int right) {
        return sumRange(left , right , 0 , 0 , n-1);
    }
    private int sumRange(int start , int end , int node, int l , int r){
        //case 1 : no overlap
        if(r < start || end < l) return 0;

        // case 2 : complete overlap
        if(start <= l && r <= end){
            return ST[node];
        }

        // case 3 : Partial Overlap
        int mid = l + (r-l)/2;
        int leftChild = 2*node + 1;
        int rightChild = 2*node+2;

        return sumRange(start , end , leftChild , l , mid ) + sumRange(start , end , rightChild , mid + 1 , r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */