package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class MinElementInOn {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			stack.add(sc.nextInt());
		}
		
		System.out.print(min(stack));
		
		sc.close();
	}
	
	static int min(Stack<Integer> s)
    {
       int min = s.peek();
       while(!s.isEmpty()){
            int top = s.pop();
            if(top <= min)
               min = top;
       }
       return min;
       
}

}
