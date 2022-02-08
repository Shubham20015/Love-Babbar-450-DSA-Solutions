package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class PreviousSmallerElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		long ans[] = prevSmaller(arr);
		
		for(int i=0;i<n;i++) {
			System.out.print(ans[i] + " ");
		}
		
		sc.close();
	}
	
	static long[] prevSmaller(long arr[]) {
		int len = arr.length;
        Stack<Long> stack = new Stack<>();
        long prev[] = new long[len];
		for(int i=0;i<len;i++){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prev[i] = -1;
            }else{
                prev[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
		return prev;
	}
}
