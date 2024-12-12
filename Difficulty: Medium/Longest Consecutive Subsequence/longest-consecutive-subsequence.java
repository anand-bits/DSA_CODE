//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.findLongestConseqSubseq(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int findLongestConseqSubseq(int[] arr) {
        // code here
        
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the HashSet
        for (int num : arr) {
            set.add(num);
        }

        int maxlength = 0;

        // Iterate over the array
        for (int num : arr) {
            // Only start a new sequence if `num-1` is not in the set (ensures starting from the smallest number in a sequence)
            if (!set.contains(num - 1)) {
                int currentnum = num;
                int currentlength = 1;

                // Count the length of the consecutive sequence
                while (set.contains(currentnum + 1)) {
                    currentnum++;
                    currentlength++;
                }

                // Update the maximum length found so far
                maxlength = Math.max(currentlength, maxlength);
            }
        }

        return maxlength;
        
        
        
    }
}