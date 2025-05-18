class Solution {
    public void swap(int[][] matrix , int i , int j)
    { 
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void reverseRow (int[] row)
    {
        int i = 0 ; int j = row.length-1;
        while(i<j)
        {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;j--;
        }
    }
    public void rotate(int[][] matrix) {
        if (matrix.length == 1)
        {
            return ;
        }
        int n = matrix.length ;
        //Transpose
        for(int i = 0 ; i < n-1 ; i++)
        {
            for(int j = i+1 ; j < n ; j++)
            {
                swap(matrix , i , j);
            }
        }
        //Reverse 
        for(int i = 0 ; i < n ; i++)
        {
            reverseRow(matrix[i]);
        }
        



    }
}