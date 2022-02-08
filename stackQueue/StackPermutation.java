package internship.stackQueue;

import java.util.*;
import java.util.Stack;
import java.util.Queue;

public class StackPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int input[] = new int[n];
		int output[] = new int[m];
		
		for(int i=0;i<n;i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			output[i] = sc.nextInt();
		}
		
		System.out.println(isPossible(input,output) ? "Yes":"No");
		
		sc.close();
	}
	
	static boolean isPossible(int input[],int output[]) {
		Queue<Integer> inputQueue = new LinkedList<>();
		Queue<Integer> outputQueue = new LinkedList<>();
		int len1 = input.length;
		int len2 = output.length;
		
		for(int i=0;i<len1;i++) {
			inputQueue.offer(input[i]);
		}
		
		for(int i=0;i<len2;i++) {
			outputQueue.offer(output[i]);
		}
		
		Stack<Integer> stack = new Stack<>();
		
		while(!inputQueue.isEmpty()) {
			int value = inputQueue.poll();
			
			if(value == outputQueue.peek()) {
				outputQueue.poll();
				while(!stack.isEmpty()) {
					if(stack.peek() == outputQueue.peek()) {
						outputQueue.poll();
						stack.pop();
					}else {
						break;
					}
				}
			}else {
				stack.push(value);
			}
		}
		
		return inputQueue.isEmpty() && stack.isEmpty();
	}

}
