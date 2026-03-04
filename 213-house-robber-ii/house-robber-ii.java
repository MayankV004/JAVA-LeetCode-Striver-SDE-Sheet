class Solution {

    public int houseRobber(int arr[]){
        int dp[] = new int[arr.length + 1];

        dp[0] = arr[0];

        for(int i = 1 ; i < arr.length ; i++){
            int pick = arr[i];

            if(i > 1) pick += dp[i-2];

            int notPick = dp[i-1];

            dp[i] = Math.max(pick , notPick);

        }

        return dp[arr.length -1];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(i != 0){
                temp1.add(nums[i]);
            }
            if(i != n-1){
                temp2.add(nums[i]);
            }
        }

        int[] arr1 = temp1.stream().mapToInt(Integer::intValue).toArray();
        int[] arr2 = temp2.stream().mapToInt(Integer::intValue).toArray();

        return Math.max(houseRobber(arr1), houseRobber(arr2));

    }
}