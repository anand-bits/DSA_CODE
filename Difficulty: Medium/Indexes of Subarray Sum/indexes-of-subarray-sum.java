//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        
        
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int currentSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Check if the current prefix sum is equal to the target
            if (currentSum == target) {
                result.add(1); // 1-based index
                result.add(i + 1);
                return result;
            }

            // Check if there is a prefix sum such that currentSum - target exists
            if (prefixSumMap.containsKey(currentSum - target)) {
                int start = prefixSumMap.get(currentSum - target) + 1; // Start index
                result.add(start + 1); // 1-based index
                result.add(i + 1);
                return result;
            }

            // Store the current prefix sum and its index
            prefixSumMap.put(currentSum, i);
        }

        // If no subarray is found, return an ArrayList with -1
        result.add(-1);
        return result;
    }
}
