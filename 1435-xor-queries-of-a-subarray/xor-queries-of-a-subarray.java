class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int xorPrefix []= new int[n];
        
        xorPrefix[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            xorPrefix[i] = xorPrefix[i-1] ^ arr[i];
        }
        int [] ans = new int[queries.length];
        int i = 0;
        for(int []query : queries){
            int start = query[0];
            int end = query[1];

            if(start > 0){
                ans[i++] = xorPrefix[end] ^ xorPrefix[start - 1];
            }else{
                ans[i++] = xorPrefix[end];
            }   
        }
        return ans;
    }
}