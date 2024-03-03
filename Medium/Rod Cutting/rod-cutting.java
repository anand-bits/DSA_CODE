//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int prices[], int n) {
        //code here
        int mat[][]= new int [n+1][n+1];
        
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                }
                else {
                    if (i == 1) {
                        mat[i][j] = j * prices[i - 1];
                    }
                    else {
                        if (i > j) {
                            mat[i][j] = mat[i - 1][j];
                        }
                        else {
                            mat[i][j] = Math.max(
                                prices[i - 1]
                                    + mat[i][j - i],
                                mat[i - 1][j]);
                        }
                    }
                }
            }
        }
         return mat[n][n];
    
    }
}