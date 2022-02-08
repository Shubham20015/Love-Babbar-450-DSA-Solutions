package internship.binaryTree;

import java.util.Scanner;

public class LowestCommonAcestor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		Node head = lca(root,a,b);
		
		System.out.println(head.data);
		
		sc.close();
	}
	
	static Node lca(Node root, int n1,int n2)
	{
		if(root == null || root.data == n1 || root.data == n2)
		    return root;
		Node left = lca(root.left,n1,n2);   
		Node right = lca(root.right,n1,n2);
		if(left == null)
		    return right;
		if(right == null)
		    return left;
		else
		    return root;
	}
}
