package internship.binaryTree;

import java.util.*;

public class InorderTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		inOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();
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
