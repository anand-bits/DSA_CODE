//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Using a Set to remove duplicates
            Set<Integer> uniqueElements = new LinkedHashSet<>();
            for (String token : tokens) {
                uniqueElements.add(Integer.parseInt(token));
            }

            // Converting the set to an array
            int[] arr = new int[uniqueElements.size()];
            int idx = 0;
            for (int num : uniqueElements) {
                arr[idx++] = num;
            }

            // Finding and printing subsets
            ArrayList<ArrayList<Integer>> res = new Solution().subsets(arr);
            for (ArrayList<Integer> subset : res) {
                if (subset.size() == 0) {
                    System.out.println("[]");
                } else {
                    for (int num : subset) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        // Sort the array to ensure subsets are generated in sorted order
         Arrays.sort(arr);
        ps(ans, arr, 0, current);
        return ans;
    }
    
    void ps(ArrayList<ArrayList<Integer>> ans, int arr[], int index, ArrayList<Integer> current) {
        // Add the current subset to the answer
        ans.add(new ArrayList<>(current));
        
        // Generate subsets by including and excluding the current element
        for (int i = index; i < arr.length; i++) {
            // Include the current element
            current.add(arr[i]);
            
            // Recursively generate subsets with the current element included
            ps(ans, arr, i + 1, current);
            
            // Exclude the current element (backtrack)
            current.remove(current.size() - 1);
        }
    }
}