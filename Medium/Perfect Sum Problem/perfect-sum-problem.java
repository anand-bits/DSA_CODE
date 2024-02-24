//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends




class Solution{

    public int perfect(int arr[],int dp[][],int index,int target)
    {
       
        if(dp[index][target]!=-1)
            return dp[index][target];
            
         if(index==0)
        {
            int count=0;
            if(arr[0]==target)
                 count++;
            if(target==0)
                 count++;
                 dp[index][target]=count;
            return count;
        }
        int taken=0,notTaken=0;
        notTaken=perfect(arr,dp,index-1,target);
        
        if(arr[index]<=target)
            taken=perfect(arr,dp,index-1,target-arr[index]);
       dp[index][target]=(taken+notTaken)%1000000007;
        return (taken+notTaken)%1000000007;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp=new int[n][sum+1];
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<sum+1;j++)
	        {
	            dp[i][j]=-1;
	        }
	    }
	    return perfect(arr,dp,n-1,sum);
	} 
}