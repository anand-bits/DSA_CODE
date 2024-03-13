//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // Initialize a table to store the lengths of longest repeating non-overlapping substrings
        int[][] dp = new int[n + 1][n + 1];
        
        // Initialize variables to store the maximum length and its ending index
        int maxLen = 0;
        int endIndex = 0;
        
        // Dynamic programming approach to fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // If characters at i-1 and j-1 are equal and substrings ending at i-1 and j-1 are non-overlapping
                if (s.charAt(i - 1) == s.charAt(j - 1) && (j - i) > dp[i - 1][j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                    // Update maxLen and endIndex if we find a longer repeating substring
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        
        // If no repeating non-overlapping substring is found
        if (maxLen == 0) {
            return "-1";
        }
        
        // Extract the repeating substring based on maxLen and endIndex
        return s.substring(endIndex - maxLen, endIndex);
    }
}