class Solution {
    private void reverse(int arr[] , int start , int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    private void nextPermutation(int arr[]){
        int idx = -1;
        int n = arr.length;
        for(int i = n-2 ; i >= 0 ; i = i - 1){
            if(arr[i] < arr[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            reverse(arr , 0 , n-1);
            return;
        }

        int swapIdx = idx;

        for(int i = n-1 ; i >= idx + 1; i--){
            if(arr[i] > arr[swapIdx]){
                int temp = arr[i];
                arr[i] = arr[swapIdx];
                arr[swapIdx] = temp;
                break;
            }
        }

        reverse(arr , swapIdx + 1 , n-1);
    }
    public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = i;
        }

        for(int i = 0 ; i < k-1 ; i++){ // as k is 1 indexed 
            nextPermutation(arr);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(arr[i]);
        }

        return sb.toString();   
    }
}