package internship.binaryTree;

import java.util.*;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		levelOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static final ArrayList<Integer> ans = new ArrayList<>();
	
	static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Node> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        ans.add(node);
        
        while(ans.size() > 0){
            Node temp = ans.get(0);
            ans.remove(temp);
            res.add(temp.data);
            if(temp.left != null)
                ans.add(temp.left);
            if(temp.right != null)
                ans.add(temp.right);    
        }
        
        return res;
    }
	
	static ArrayList<Integer> inOrderIterative(Node root)
    {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.add(curr);
                curr = curr.left;
                continue;
            }
            curr = stack.pop();
            ans.add(curr.data);
            curr = curr.right;
        }
        return ans;
    }
}
