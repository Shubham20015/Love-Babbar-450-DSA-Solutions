package internship.binarySearchTree;

import java.util.*;

public class BTtoBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		root = binaryTreeToBST(root);
		
		inorder(root);
		
		sc.close();

	}
	
	static ArrayList<Integer> arr = new ArrayList<>();
    static int i = 0;
    
    static Node binaryTreeToBST(Node root)
    {
       if(root == null) return null;    
       inorder(root);
       Collections.sort(arr);
       construct(root);
       return root;
    }
    
    static void inorder(Node root){
        if(root == null)
            return ;
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
    }
    
    static void construct(Node root){
        if(root == null)
            return ;
        construct(root.left);
        root.data = arr.get(i++);
        construct(root.right);
    }

}
