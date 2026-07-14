class Solution {
    int count = 0;
    public void allPermutations(char []arr , boolean used[]){
        count ++;

        for(int i = 0 ; i < arr.length ; i++){
            if(used[i]) continue;

            if(i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;

            used[i] = true;
            allPermutations(arr , used);
            used[i] = false;
        }
    }
    public int numTilePossibilities(String tiles) {
        char arr[] = tiles.toCharArray();
        Arrays.sort(arr);
        boolean used[] = new boolean[tiles.length()];
        allPermutations(arr , used);
        return count-1; // -1 for eleminating the count of empty permutation
    }
}