class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int it : nums1){
            set.add(it);
        }

        HashSet<Integer> res = new HashSet<>();
        for(int it : nums2){
            if(set.contains(it)){
                res.add(it);
            }
        }

        int n = res.size();
        int []ans = new int[n];
        int i = 0;
        for(int it : res){
            ans[i++] = it;
        }

        return ans;
    }
}