//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size(); // Size of the matrix

        // Directions for moving (right, left, down, up)
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        char[] dir = new char[]{'R', 'L', 'D', 'U'}; // Directions as characters
        
        // Check if the starting or ending point is blocked
        if (mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0) {
            return ans;
        }

        // Queue for BFS: Each element is {x, y, path, visited}
        Queue<State> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n]; // Temporary visited array for each state
        visited[0][0] = true;
        q.add(new State(0, 0, "", visited));

        // BFS
        while (!q.isEmpty()) {
            State current = q.poll();
            int x = current.x;
            int y = current.y;
            String path = current.path;

            // If we've reached the bottom-right corner, add the path to the answer
            if (x == n - 1 && y == n - 1) {
                ans.add(path);
                continue;
            }

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int posX = x + dx[i];
                int posY = y + dy[i];

                // Check if the new position is valid and not visited in this path
                if (posX >= 0 && posX < n && posY >= 0 && posY < n &&
                    mat.get(posX).get(posY) == 1 && !current.visited[posX][posY]) {
                    // Create a copy of the visited array for this path
                    boolean[][] newVisited = new boolean[n][n];
                    for (int r = 0; r < n; r++) {
                        System.arraycopy(current.visited[r], 0, newVisited[r], 0, n);
                    }
                    newVisited[posX][posY] = true;
                    q.add(new State(posX, posY, path + dir[i], newVisited));
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    // Helper class to store (x, y, path, visited array)
    static class State {
        int x, y;
        String path;
        boolean[][] visited;

        State(int x, int y, String path, boolean[][] visited) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.visited = visited;
        }
    }
}
