//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        // code here
        
        StringBuilder input1 = new StringBuilder();
 
        // append a string into StringBuilder input1
        input1.append(S);
 
        // reverse StringBuilder input1
        input1.reverse();
        String S2= input1.toString();
        
        int n=S2.length();
        int dp[][]=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
              
                
                if(S.charAt(i-1)==S2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                    
                }
                else
                {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                    
                }
            }
        }
        
        int lcs= dp[n][n];
        
        return n-lcs;
        
    }
}