//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine().trim());
        while(t-->0)
        {
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]=Integer.parseInt(s[j]);
                }
            }
            Solution ob=new Solution();
            ob.transpose(n,a);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    out.print(a[i][j]+" ");
                }out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public void transpose(int n,int a[][])
    {
        int row=a.length;
        int col=a[0].length;
        
        int b[][]= new int[row][col];
        
        // Transpose the matrix
for (int i = 0; i < row; i++)
{
    for (int j = 0; j < col; j++)
    {
        b[j][i] = a[i][j];
    }
}

// Copy the transposed values back to the original array
for (int i = 0; i < row; i++)
{
    for (int j = 0; j < col; j++)
    {
        a[i][j] = b[i][j];
    }
}

}
}