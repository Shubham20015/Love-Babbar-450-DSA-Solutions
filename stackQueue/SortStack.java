package internship.stackQueue;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(41);
		stack.push(3);
		stack.push(32);
		stack.push(2);
		stack.push(11);
		Stack<Integer> ans = sort(stack);
		
		while(!ans.isEmpty()) {
			System.out.print(ans.pop() + " ");
		}
	}
	
//	TC: O(N*N) , SC:O(N)
	static Stack<Integer> sort(Stack<Integer> s)
	{
		if(!s.isEmpty()){
		    int x = s.pop();
	        sort(s);
	        insert(s,x);
		}
//	    If void return type then this return condition don't needed
	    return s;
	}
	
	static void insert(Stack<Integer> s,int value){
	    if(s.isEmpty() || value > s.peek()){
	        s.add(value);
	        return ;
	    }
	    int val = s.pop();
	    insert(s,value);
	    s.add(val);
	}
}
