class Solution {

    public boolean dfs(int nums[] , int idx , int bucket[] , int target){
        if(idx == nums.length) return true;

        int val = nums[idx];

        for(int i = 0 ; i < bucket.length ; i++){
            if(bucket[i] + val > target) continue;

            bucket[i] += val;
            if(dfs(nums , idx + 1 , bucket , target)) return true; 
            bucket[i] -= val;

            if(bucket[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int it : nums) {
            sum += it;
        }

        if (sum % k != 0)
            return false;

        int target = sum / k; // sum for each bucket

        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;

        while (l < r) { // reversing  -> because it will be easier to fill the buckets
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        int bucket[] = new int[k];

        return dfs(nums, 0, bucket, target);
    }
}