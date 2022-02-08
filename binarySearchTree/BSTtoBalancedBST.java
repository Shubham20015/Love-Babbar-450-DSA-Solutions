package internship.binarySearchTree;

import java.util.*;

public class BSTtoBalancedBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree tree = new BinarySearchTree();
    	
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			tree.insert(sc.nextInt());
		}
		
        tree.inorder();
        System.out.println();
        tree.root = buildBalancedTree(tree.root);
        tree.inorder();
        
		sc.close();
	}
	
	static ArrayList<Integer> arr = new ArrayList<>();
	
    static Node buildBalancedTree(Node root) 
    {
        if(root == null) return root;
        inorder(root);
        return solve(0,arr.size()-1);
    }
    
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
    }
    
    static Node solve(int low,int high){
        if(low > high) return null;
        int mid = (low+high)/2;
        Node root = new Node(arr.get(mid));
        root.left = solve(low,mid-1);
        root.right = solve(mid+1,high);
        return root;
    }

}
