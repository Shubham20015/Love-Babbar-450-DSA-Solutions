package internship.stackQueue;

import java.util.Stack;
import java.util.Scanner;

public class ArithmeticExpressionEvaluation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String expression = sc.next();
		String resExp = postfixConversion(expression);
		
		int ans = evaluate(resExp);
		System.out.println(ans);
		
		sc.close();
	}
	
	static int prec(char ch) {
		switch(ch) {
			case '+':
			case '-': return 1; 
			case '*':
			case '/': return 2; 
			case '^': return 3; 
		}
		return  -1;
	}
	
	static String postfixConversion(String exp) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		int n = exp.length();
		for(int i=0;i<n;i++) {
			char ch = exp.charAt(i);
			
			if(Character.isDigit(ch) || Character.isAlphabetic(ch)) {
				result += ch;
			}
			else if(ch == '(')
				stack.add(ch);
			else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			}else {
				while(!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
					result += stack.pop();
				}
				stack.add(ch);
			}
		}
		
		while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "#";
            result += stack.pop();
        }

		return result;
	}
	
	static int evaluate(String exp) {
		if(exp == "#")
			return -1;
		int n = exp.length();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			char ch = exp.charAt(i);
			if(Character.isDigit(ch)) {
				int value = ch - '0';
				stack.add(value);
			}else if(ch == '+') {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.add(num1+num2);
			}else if(ch == '-') {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.add(num1-num2);
			}else if(ch == '*') {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.add(num1*num2);
			}else if(ch == '/') {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.add(num1/num2);
			}else if(ch == '^') {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.add((int)Math.pow(num1,num2));
			}
		}
		return stack.pop();
	}
}
