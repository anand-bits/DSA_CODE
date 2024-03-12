//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

import java.util.*;

class Solution {
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of elements in A1
        for(int i = 0; i < N; i++) {
            map.put(A1[i], map.getOrDefault(A1[i], 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> remaining = new TreeSet<>();
        
        // Traverse A2 to maintain the order
        for(int i = 0; i < M; i++) {
            int num = A2[i];
            if(map.containsKey(num)) {
                int count = map.get(num);
                for(int j = 0; j < count; j++) {
                    list.add(num);
                }
                // Remove the processed element from the map
                map.remove(num);
            }
        }
        
        // Add remaining elements from A1 not present in A2 to TreeSet
        for(int num : map.keySet()) {
            int count = map.get(num);
            for(int j = 0; j < count; j++) {
                remaining.add(num);
            }
        }
        
        // Add remaining elements from TreeSet to the list
        for(int num : remaining) {
            int count = map.get(num);
            for(int j = 0; j < count; j++) {
                list.add(num);
            }
        }
        
        // Convert List<Integer> to int[]
        int[] sortedArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            sortedArray[i] = list.get(i);
        }

        return sortedArray;
    }
}




//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends