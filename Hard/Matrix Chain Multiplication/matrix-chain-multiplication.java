//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        // Create a 2D array to store the minimum number of multiplications
        // dp[i][j] represents the minimum number of multiplications needed to
        // multiply matrices from index i to j in the arr array
        int[][] dp = new int[N][N];

        // Initialize the dp array with 0s
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = 0;
            }
        }

        // Fill the dp array using bottom-up dynamic programming
        // Iterate over the chain length (l) from 2 to N-1
        for (int l = 2; l < N; l++) {
            // Iterate over the start index of the chain
            for (int i = 1; i < N - l + 1; i++) {
                // Calculate the end index of the chain
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // Iterate over the partitioning point within the chain
                for (int k = i; k <= j - 1; k++) {
                    // Calculate the number of multiplications needed to
                    // multiply matrices from i to k and k+1 to j
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    // Update dp[i][j] if the current cost is lower
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }

        // Return the minimum number of multiplications needed to multiply all matrices
        return dp[1][N - 1];
    }
}
