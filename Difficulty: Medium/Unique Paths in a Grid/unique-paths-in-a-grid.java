//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution {
    static final int MOD = 1000000007;

    static int uniquePaths(int n, int m, int[][] grid) {
        // If the starting or ending cell is blocked, no path exists
        if (grid[0][0] == 0 || grid[n - 1][m - 1] == 0) {
            return 0;
        }

        // Initialize a DP table
        int[][] dp = new int[n][m];
        dp[0][0] = 1; // Starting point

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Skip blocked cells
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                // Add paths from the top cell if valid
                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }

                // Add paths from the left cell if valid
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        // The result is in the bottom-right cell
        return dp[n - 1][m - 1];
    }
}