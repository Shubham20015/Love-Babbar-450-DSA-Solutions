package internship.binarySearchTree;

import java.util.Scanner;

public class FlattenBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		BinarySearchTree tree = new BinarySearchTree();
		
		for(int i=0;i<n;i++) {
			tree.insert(sc.nextInt());
		}
		
		tree.root = flatten(tree.root);
		tree.inorder();
		
		sc.close();
	}
	
//	TC: O(N) , SC: O(N)
	static Node prev;
	
	static Node flatten(Node root) {
		Node dummy = new Node(-1);
		
		prev = dummy;
		inorder(root);
		
		prev.left = null;
		prev.right = null;
		
		return dummy.right;
	}
	
	static void inorder(Node curr) {
		if(curr == null) return;
		inorder(curr.left);
		prev.left = null;
		prev.right = curr;
		prev = curr;
		inorder(curr.right);
	}
	
	

}
