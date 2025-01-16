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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution {
    public boolean isWordExist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, word, 0, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean find(char[][] board, String word, int idx, int i, int j, int m, int n) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$' || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$'; // Mark as visited

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        for (int k = 0; k < 4; k++) {
            int Xdx = i + dx[k];
            int Ydy = j + dy[k];

            if (find(board, word, idx + 1, Xdx, Ydy, m, n)) {
                return true;
            }
        }

        board[i][j] = temp; // Revert the change
        return false;
    }
}