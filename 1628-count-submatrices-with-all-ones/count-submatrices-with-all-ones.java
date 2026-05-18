class Solution {
    private int countSubarraysOfOnes(int[] arr) {
        int consecutiveOnes = 0;
        int subarrayCount = 0;

        for (int val : arr) {
            if (val == 0) {
                consecutiveOnes = 0;
            } else {
                consecutiveOnes++;
            }
            subarrayCount += consecutiveOnes;
        }

        return subarrayCount;
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int start = 0; start < m; start++) {

            int arr[] = new int[n];
            Arrays.fill(arr, 1);

            for (int end = start; end < m; end++) {

                for (int col = 0; col < n; col++) {
                    arr[col] = arr[col] & mat[end][col];
                }

                ans += countSubarraysOfOnes(arr);

            }
        }
        return ans;
    }
}

/*
========================================================
EXPLANATION
========================================================

PATTERN USED:
--------------
2D -> 1D Reduction (Row Compression Technique)

We fix:
- top row
- bottom row

Then convert the matrix between these rows
into a 1D binary array.

--------------------------------------------------------

VISUALIZATION
========================================================

Matrix:

1 0 1
1 1 0
1 1 0

--------------------------------------------------------
STEP 1:
Fix top row = 0
--------------------------------------------------------

Initially:

arr = [1,1,1]

--------------------------------------------------------
Bottom row = 0
--------------------------------------------------------

Take AND with row 0:

arr = [1,0,1]

Now count subarrays of ones.

Possible subarrays:
[1]
[1]

Total = 2

These represent submatrices:

1       1

--------------------------------------------------------
Bottom row = 1
--------------------------------------------------------

AND with row 1:

Previous arr = [1,0,1]
Row 1        = [1,1,0]

New arr      = [1,0,0]

Subarrays:
[1]

Total = 1

This represents rectangle:

1
1

--------------------------------------------------------
Bottom row = 2
--------------------------------------------------------

AND with row 2:

Previous arr = [1,0,0]
Row 2        = [1,1,0]

New arr      = [1,0,0]

Subarrays:
[1]

Total = 1

Rectangle:

1
1
1

--------------------------------------------------------

Then repeat for:
top row = 1
top row = 2

========================================================
WHY DOES countSubarraysOfOnes WORK?
========================================================

Example:

arr = [1,1,1]

At index 0:
streak = 1
Subarrays ending here:
[1]

At index 1:
streak = 2
Subarrays ending here:
[1]
[1,1]

At index 2:
streak = 3
Subarrays ending here:
[1]
[1,1]
[1,1,1]

Total:
1 + 2 + 3 = 6

========================================================
TIME COMPLEXITY
========================================================

Outer loops:
O(m^2)

For each pair of rows:
O(n)

Total:
O(m^2 * n)

Space:
O(n)

========================================================
CORE IDEA
========================================================

Fix two rows
      ↓
Compress into 1D binary array
      ↓
Count subarrays of consecutive 1s
      ↓
Each subarray represents one valid submatrix

========================================================
*/