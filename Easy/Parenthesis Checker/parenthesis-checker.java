//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends





class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            char currentChar = x.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stk.push(currentChar);
            } else {
                if (stk.isEmpty()) {
                    return false; // Unmatched closing bracket, return false
                }

                char topChar = stk.peek();
                if ((currentChar == ')' && topChar == '(') ||
                    (currentChar == '}' && topChar == '{') ||
                    (currentChar == ']' && topChar == '[')) {
                    stk.pop(); // Matching pair, pop the opening bracket from the stack
                } else {
                    return false; // Mismatched closing bracket, return false
                }
            }
        }

        return stk.isEmpty(); // If the stack is empty, all brackets are balanced
    }
}

