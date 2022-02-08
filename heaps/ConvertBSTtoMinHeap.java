package internship.heaps;

import java.util.LinkedList;

public class ConvertBSTtoMinHeap {
	
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	static void BSTtoArray(Node root,LinkedList<Integer> list) {
		if(root == null)
			return ;
		
		BSTtoArray(root.left,list);
		list.add(root.data);
		BSTtoArray(root.right,list);
	}
	
	static void arrayToMinHeap(Node root,LinkedList<Integer> list) {
		if(root == null)
			return ;
		
		root.data = list.removeFirst();
		arrayToMinHeap(root.left,list);
		arrayToMinHeap(root.right,list);
	}
	
	static void convertToHeap(Node root) {
		LinkedList<Integer> list = new LinkedList<>();
		BSTtoArray(root,list);
		arrayToMinHeap(root,list);
	}
	
	static void preorder(Node root) {
		if(root == null)
			return ;
		
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
	    root.left = new Node(2);
	    root.right = new Node(6);
	    root.left.left = new Node(1);
	    root.left.right = new Node(3);
	    root.right.left = new Node(5);
	    root.right.right = new Node(7);
	     
	    System.out.print("Preorder Traversal Before Conversion :" +"\n");
	    preorder(root);
	    convertToHeap(root);
	     
	    System.out.print("\nPreorder Traversal After Conversion :" +"\n");
	    preorder(root);
	}
}
