package internship.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(reverse(str));
		
		sc.close();
	}
	
	static String reverse(String S){
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        for(int i=0;i<len;i++){
            char ch = S.charAt(i);
            stack.add(ch);
        }
        
        String ans = "";
        for(int i=0;i<len;i++){
            ans += stack.pop();
        }
        
        return ans;
    }

}
