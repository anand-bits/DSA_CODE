//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    
    static final int MOD = 1000000007;
    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n) {
        int arr[] = {1, 2, 3};

        // Initialize dp array with -1 to indicate uncalculated values.
        long[][] dp = new long[4][n + 1];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, arr, dp, 0)% MOD;
    }

    static long solve(int n, int arr[], long dp[][], int index) {
        // Base cases
        if (n == 0) {
            return 1;
        }

        if (n < 0 || index >= arr.length) {
            return 0;
        }

        // If already calculated, return the value from dp
        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        // Calculate the number of ways recursively by choosing the current step or skipping it.
        long ways = 0;
        for (int i = 0; i < arr.length; i++) {
            if (n >= arr[i]) {
                ways += solve(n - arr[i], arr, dp, i)% MOD; // Note: Using i instead of index + 1
            }
        }

        // Memoize the result
        dp[index][n] = ways% MOD;

        return ways;
    }
}
