//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String str, int n)
    {
        // code here
        
        String S2 = new StringBuilder(str).reverse().toString();
        
        int m= S2.length();
        
        int dp[][]= new int [n+1][m+1];
        
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(str.charAt(i-1)==S2.charAt(j-1))
                {
                    dp[i][j]= 1+dp[i-1][j-1];
                    
                }
                else
                {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                    
                }
            }
        }
        int lcs=dp[n][m];
        
        return m-lcs;
    }
} 