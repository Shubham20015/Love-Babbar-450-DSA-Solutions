package internship.binaryTree;

import java.util.*;

public class LargestSubtreeSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String str = sc.next();
//		BinaryTree tree = new BinaryTree();
//		Node root = tree.buildTree(str);
		
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
		
		largestSum(root);
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static int ans = Integer.MIN_VALUE;
	
	static int largestSum(Node root) {
		if(root == null)
			return 0;
		
		int currSum = root.data + largestSum(root.left) + largestSum(root.right);
		
		ans = Math.max(currSum, ans);
		
		return currSum;
	}
}
