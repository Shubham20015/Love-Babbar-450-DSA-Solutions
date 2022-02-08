package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectAreaInHist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}

		long ans = getMaxArea(arr,n);
		
		System.out.print("Max area of rectangle in histogram: " + ans);
		
		sc.close();
	}
	
	public static long getMaxArea(long hist[], int n) 
    {
        int len = n;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        long prev[] = new long[len];
        long next[] = new long[len];
        
        for(int i=0;i<len;i++){
            
            while(!stack1.isEmpty() && hist[stack1.peek()] >= hist[i]){
                stack1.pop();
            }
            if(stack1.isEmpty()){
                prev[i] = -1;
            }else{
                prev[i] = stack1.peek();
            }
            stack1.push(i);
        }
        
        for(int i=len-1;i>=0;i--){
            
            while(!stack2.isEmpty() && hist[stack2.peek()] >= hist[i]){
                stack2.pop();
            }
            if(stack2.isEmpty()){
                next[i] = len;
            }else{
                next[i] = stack2.peek();
            }
            stack2.push(i);
        }
        
        long maxArea = -1;
        for(int i=0;i<len;i++){
            maxArea = Math.max(maxArea,(next[i]-prev[i]-1)*hist[i]);
        }
        
        return maxArea;
    }

}
