class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0 ;
        int high = arr.length - 1;

        while(low <= high){
            if(high - low + 1 == k){
                break;
            }

            int left = Math.abs(arr[low] - x);
            int right = Math.abs(arr[high] - x);

            if(left <= right ){
                high--;
            }else{
                low++;
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = low ; i <= high ; i++ ){
            res.add(arr[i]);
        }

        return res;
    }
}