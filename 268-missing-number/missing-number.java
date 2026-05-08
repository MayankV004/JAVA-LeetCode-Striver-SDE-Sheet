class Solution {
    public int missingNumber(int[] nums) {
        //solution 1
        // Arrays.sort(nums);
        // if(nums[0] != 0 )
        // {
        //     return 0;
        // }
        // int i = 0;
        // for (i = 0 ; i < nums.length - 1; i++)
        // {
        //     if (nums[i] + 1 != nums[i+1] )
        //     {
        //         return nums[i] + 1;
        //     }
            
        // }
        // return nums.length;
        
        // solution 2

        int count[] = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] < nums.length)
            {
                count[nums[i]] = 1;
            }
        }
        for(int i = 0 ; i < nums.length ; i++)
        {
            if (count[i] == 0) return i;
        }
        return nums.length;


    }
}