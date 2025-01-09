//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Knight's possible moves
        int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dy = {1, -1, -2, -2, -1, 1, 2, 2};

        // Starting and target positions
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;

        // If already at the target
        if (startX == targetX && startY == targetY) {
            return 0;
        }

        // BFS initialization
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // (x, y, steps)
        visited[startX][startY] = true;

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];

            // Explore all possible knight moves
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // Check if the move is within bounds and not visited
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    // If the target is reached, return the steps
                    if (nx == targetX && ny == targetY) {
                        return steps + 1;
                    }

                    // Mark as visited and add to the queue
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, steps + 1});
                }
            }
        }

        // If target is not reachable (shouldn't happen for a valid board)
        return -1;
    }
}
