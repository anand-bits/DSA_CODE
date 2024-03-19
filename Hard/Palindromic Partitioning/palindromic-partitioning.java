//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int palindromicPartition(String str) {
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] minCuts = new int[n];

        // Initialize minCuts with the worst case where each character is a partition
        for (int i = 0; i < n; i++) {
            minCuts[i] = i;
        }

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                // Check if the substring from start to end is a palindrome
                if (str.charAt(start) == str.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;

                    // Update minCuts if a palindrome is found
                    if (start == 0) {
                        minCuts[end] = 0; // no cut needed if the whole string is a palindrome
                    } else {
                        minCuts[end] = Math.min(minCuts[end], minCuts[start - 1] + 1);
                    }
                }
            }
        }

        return minCuts[n - 1];
    }
}
