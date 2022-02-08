package internship.binarySearchTree;

import java.util.Scanner;

public class FlattenBinaryTreeIntoLL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		root = flattenTree(root);
		
		inorder(root);
		
		sc.close();

	}
	
	static Node flattenTree(Node root) {
		Node curr = root;
		while(curr != null) {
			if(curr.left != null) {
				Node prev = curr.left;
				while(prev.right != null)
					prev = prev.right;
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
		return root;
	}
	
	static void inorder(Node root){
        if(root == null)
            return ;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}
