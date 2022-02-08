package internship.binaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class MirrorTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		System.out.println("After making mirror of tree: ");
		
		mirror(root);
		inOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static void mirror(Node node) {
	       if(node == null) return;
	       
	       Node temp = node.left;
	       node.left = node.right;
	       node.right = temp;
	       
	       mirror(node.left);
	       mirror(node.right);
	 }
	
	static final ArrayList<Integer> ans = new ArrayList<>();
	  
    static ArrayList<Integer> inOrder(Node root) {
        
        if(root == null) return ans;
        
        inOrder(root.left);
        ans.add(root.data);
        inOrder(root.right);
        return ans;
    }
}
