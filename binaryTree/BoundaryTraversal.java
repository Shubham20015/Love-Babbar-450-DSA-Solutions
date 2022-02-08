package internship.binaryTree;

import java.util.ArrayList;
import java.util.*;

public class BoundaryTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<Integer> ans = boundary(root);
		
		for(int val: ans) {
			System.out.print(val + " ");
		}
		
		sc.close();

	}
	
	static ArrayList<Integer> boundary(Node root)
	{
	    ArrayList<Integer> arr = new ArrayList<>();
	    if(root == null)
	        return arr;
	    if(!isLeaf(root))
	        arr.add(root.data);
	    leftBoundary(root,arr);
	    addLeaves(root,arr);
	    rightBoundary(root,arr);
	    return arr;     
	}
	
	static boolean isLeaf(Node root){
	    return root.left == null && root.right == null;
	}
	
	static void leftBoundary(Node root,ArrayList<Integer> arr){
	    Node curr = root.left;
	    while(curr != null){
	        if(!isLeaf(curr))
	            arr.add(curr.data);
	        if(curr.left != null) curr = curr.left;
	        else curr = curr.right;
	    }
	}
	
	static void addLeaves(Node root,ArrayList<Integer> arr){
	    if(isLeaf(root)) arr.add(root.data);
	    if(root.left != null) addLeaves(root.left,arr);
	    if(root.right != null) addLeaves(root.right,arr);
	}
	
	static void rightBoundary(Node root,ArrayList<Integer> arr){
	    Stack<Integer> stack = new Stack<>();
	    Node curr = root.right;
	    while(curr != null){
	        if(!isLeaf(curr))
	            stack.add(curr.data);
	        if(curr.right != null) curr = curr.right;
	        else curr = curr.left;
	    }
	    
	    while(!stack.isEmpty())
	        arr.add(stack.pop());
	}

}
