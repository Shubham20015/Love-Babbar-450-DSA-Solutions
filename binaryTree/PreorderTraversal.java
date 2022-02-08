package internship.binaryTree;

import java.util.*;

public class PreorderTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		preOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
    
    static final ArrayList<Integer> ans = new ArrayList<>();
 
    static ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    
    static void helper(Node root,ArrayList<Integer> ans){
        
        if(root == null) return ;
        
        ans.add(root.data);
        helper(root.left,ans);
        helper(root.right,ans);
    }
    
    static ArrayList<Integer> preOrderIterative(Node root)
    {
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                ans.add(curr.data);
                stack.add(curr);
                curr = curr.left;
                continue;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return ans;
    }
}
