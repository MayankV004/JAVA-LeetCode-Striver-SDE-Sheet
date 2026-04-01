class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        Integer []actualIndex = new Integer[n]; // Making a Integer type array to use lambda expression for sorting the actual Index
        for(int i = 0 ; i < n ; i++) 
        {
            actualIndex[i] = i;  // 0,1,2, ... n-1 
        } 
        /*
        Sorting the actual index array according to the positions in the position array in increasing order
        eg . position = [3,5,2,6]
                         0 1 2 3 -> actual indexes
        but on number line order should be 
            1       2       3       4       5       6      -> According to positions array
        ----|-------|-------|-------|-------|-------|----
                    2       0               1       3       -> actual indexes

            After sorting acutal index array it should be looking like = [2,0,1,3] 
            -> : In this order we will be processing the data using Stack -> storing the indexes
            We will start from processing the right moving Robots 
            -> push them in stack 
            -> and if the robot is left moving we will first pop the top  from the stack and then compare is from the robot at current Index
            
            while(!stack.isEmpty() && health[currentIndex] > )
            {
            -> if health[top] > health[current Index]
               then reduce 1 from health of top and make health of current index 0 
               as it is destroyed because if low health
               and push Top back to the stack as it is not destroyed yet
            -> else if health[top] < health[current Index]
               then make health of top = 0 
                    make health of current Index -= 1 
            -> else 
                means both robots have equal healths 
                    then make healths of both the robots 0 
                    as both are destroyed in the collision
            }

            now just add the healths which are greater than 0
            and return result
            
        */
        Arrays.sort(actualIndex , (i,j) -> Integer.compare(positions[i] , positions[j]));

        for(int currIdx : actualIndex)
        {   // adding Right moving robots in the stack
            if(directions.charAt(currIdx) == 'R')
            {
                stack.push(currIdx);
            }
            else
            {
                while(!stack.isEmpty() && healths[currIdx] > 0)
                {
                    int top = stack.pop();

                    if(healths[top] > healths[currIdx]) // top destroys currentIndex
                    {
                        healths[top] -= 1;
                        healths[currIdx] = 0;
                        stack.push(top);
                    }
                    else if( healths[top] < healths[currIdx] ) // currentIndex destroys top
                    {
                        healths[top] = 0;
                        healths[currIdx] -= 1;
                    }
                    else  // both destroyed each other
                    {
                        healths[top] = 0;
                        healths[currIdx] = 0;
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++)
        {
            if(healths[i] > 0) // adding those robots which have health greater than 0 means -> surviving robots
            {
                result.add(healths[i]);
            }
        }
        return result;
    }
}