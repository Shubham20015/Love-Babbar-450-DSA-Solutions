package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		long ans[] = nextSmaller(arr);
		
		for(int i=0;i<n;i++) {
			System.out.print(ans[i] + " ");
		}
		
		sc.close();
	}
	
	static long[] nextSmaller(long arr[]) {
		int len = arr.length;
        Stack<Long> stack = new Stack<>();
        long next[] = new long[len];
		for(int i=len-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                next[i] = -1;
            }else{
                next[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
		return next;
	}

}
