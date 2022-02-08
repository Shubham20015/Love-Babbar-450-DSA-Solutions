package internship.binaryTree;

import java.util.Scanner;

public class TreeToDLL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		Node head = bToDLL(root);
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.left;
		}
		
		System.out.println();
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
		
		
		sc.close();

	}
	
	static Node headDLL,prev;
    
    static Node bToDLL(Node root)
    {
	    if(root == null){
	        return null;
	    }
	    bToDLL(root.left);
	    if(prev == null){
	        headDLL = root;
	    }else{
	        root.left = prev;
	        prev.right = root;
	    }
	    prev = root;
	    bToDLL(root.right);
	    return headDLL;
    }

}
