//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countOfSubstrings(S,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static int countOfSubstrings(String S, int K) {
      int count = 0;
        int n = S.length();
        
        // Count the frequency of characters in the first K characters
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < K; i++) {
            charCount.put(S.charAt(i), charCount.getOrDefault(S.charAt(i), 0) + 1);
        }
        
        // Check if the first K characters meet the condition
        if (charCount.size() == K - 1) {
            count++;
        }
        
        // Slide the window and update character count
        for (int i = K; i < n; i++) {
            char leftChar = S.charAt(i - K);
            char rightChar = S.charAt(i);
            
            // Update character count for the sliding window
            charCount.put(leftChar, charCount.get(leftChar) - 1);
            if (charCount.get(leftChar) == 0) {
                charCount.remove(leftChar);
            }
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            // Check if the sliding window meets the condition
            if (charCount.size() == K - 1) {
                count++;
            }
        }
        
        return count;
    }
}