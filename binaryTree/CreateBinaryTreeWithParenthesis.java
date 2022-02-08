package internship.binaryTree;

import java.util.*;

public class CreateBinaryTreeWithParenthesis {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Node root = createTree(str);
		InorderTraversal.inOrder(root);
		
		for(int val: InorderTraversal.ans) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
	static int start = 0;
	
	static Node createTree(String str) {
		if(str.length() == 0 || str == null)
			return null;
		if(start >= str.length())
			return null;
		boolean neg = false;
		
		if(str.charAt(start) == '-') {
			neg = true;
			start++;
		}
		
		int num = 0;
		while(start < str.length() && Character.isDigit(str.charAt(start))) {
			int digit = Character.getNumericValue(str.charAt(start));
			num = num * 10 + digit;
			start++;
		}
		
		if(neg) num = -num;
		
		Node root = new Node(num);
		
		if(start >= str.length()) {
			return root;
		}
		
		if(start < str.length() && str.charAt(start) == '(') {
			start++;
			root.left = createTree(str);
		}
		
		if(start < str.length() && str.charAt(start) == ')') {
			start++;
			return root;
		}
		
		if(start < str.length() && str.charAt(start) == '(') {
			start++;
			root.right = createTree(str);
		}
		
		if(start < str.length() && str.charAt(start) == ')') {
			start++;
			return root;
		}
		return root;
	}
}
