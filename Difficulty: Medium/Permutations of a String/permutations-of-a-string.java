//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.findPermutation(S);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution {
    public List<String> findPermutation(String s) {
        List<String> ans = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        StringBuilder path = new StringBuilder();

        if (s.length() == 0) {
            return ans;
        }

        // Sort the string to group duplicates together
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Start backtracking
        solve(chars, path, visited, ans);

        return ans;
    }

    private void solve(char[] s, StringBuilder path, boolean[] visited, List<String> ans) {
        if (path.length() == s.length) {
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            // Skip already visited characters
            if (visited[i]) {
                continue;
            }

            // Skip duplicate characters unless it's the first instance or the previous instance is used
            if (i > 0 && s[i] == s[i - 1] && !visited[i - 1]) {
                continue;
            }

            // Add the character to the current path and mark it as visited
            path.append(s[i]);
            visited[i] = true;

            // Recurse
            solve(s, path, visited, ans);

            // Backtrack
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}
