//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(N,A, target));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int findTargetSumWays( int N, int[] A ,int target) {
        // code here
        target=Math.abs(target);
        for(int i = 0;i < N;i++)
            A[i] = Math.abs(A[i]);
            
        int sum=Arrays.stream(A).sum();
       
        if((sum+target)%2!=0)
            return 0;
        int s1=(sum+target)/2;
        return noOfWays(s1,A,N);
    }
    static int noOfWays(int sum,int[] arr, int n){
        int dp[][]=new int [n+1][sum+1];
        dp[0][0]=1;
        int mod=1000000007;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                int include=0;
                if(j>=arr[i-1])
                    include=dp[i-1][j-arr[i-1]];
                int exclude=dp[i-1][j];
                dp[i][j]=(include+exclude)%mod;
            }
        }
        return dp[n][sum];
    }
};