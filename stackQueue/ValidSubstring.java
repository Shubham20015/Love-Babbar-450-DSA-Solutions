package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class ValidSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		System.out.println(findMaxLen(str));
		System.out.println(findMaxLength(str));
		
		sc.close();
	}
	
//	TC: O(N) , SC: O(N)
	 static int findMaxLen(String S) {
	        Stack<Integer> stack = new Stack<>();
	        int n = S.length();
	        int ans = 0;
	        stack.push(-1); // to calculate length of string in intial condition equal to 2
	        for(int i=0;i<n;i++){
	            if (S.charAt(i) == '(') 
	                stack.push(i);
	            else{
	            	stack.pop();
	            	if(stack.isEmpty())
	            		stack.push(i);
	            	else
		                ans = Math.max(ans,i-stack.peek());
	            }
	        }
	        return ans;
	    }
	
//	TC: O(N) , SC: O(1)
	static int findMaxLength(String S) {
        int n = S.length();
        int max = 0,open = 0,close = 0;
        
//      calculate for prefix 
        for(int i=0;i<n;i++){
            char ch = S.charAt(i);
            if(ch == '(')
            	open++;
            else
            	close++;
            
            if(open == close)
                max = Math.max(max,2*close); // 2*close -> left + close
            else if(close > open)   // Eg: (())()) 
            	open = close = 0;
        }
        
        open = close = 0;
        
//      calculate for suffix 
        for(int i=n-1;i>=0;i--){
            char ch = S.charAt(i);
            if(ch == '(')
            	open++;
            else
            	close++;
            
            if(open == close)
                max = Math.max(max,2*close); // 2*close -> left + close
            else if(open > close)   // Eg: ((((()) 
            	open = close = 0;
        }
        return max;
    }
}
