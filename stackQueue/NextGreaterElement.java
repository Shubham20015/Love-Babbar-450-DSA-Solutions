package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		long ans[] = nextLargerElement(arr,n);
		
		for(int i=0;i<n;i++) {
			System.out.print(ans[i] + " ");
		}
		
		sc.close();

	}
	
	static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> stack = new Stack<>();
        long ans[] = new long[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    } 

}
