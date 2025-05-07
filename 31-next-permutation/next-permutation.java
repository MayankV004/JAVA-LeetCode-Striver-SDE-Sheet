class Solution {
    public void Reverse(int[]arr , int i , int j)
    {
        while(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++ ; j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i = n-2 ; i >= 0 ; i--)
        {
            if(nums[i] < nums[i+1])
            {
                idx = i;
                break;
            }
        }

        if(idx == -1)
        {
            Reverse(nums , 0 , nums.length-1);
            return;
        }
        for(int i = n-1 ; i>= idx ; i--)
        {
            if(nums[i] > nums[idx])
            {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        Reverse(nums , idx + 1 , n-1);
    }
}