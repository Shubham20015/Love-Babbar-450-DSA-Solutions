package internship.binaryTree;

import java.util.*;

public class PostOrderTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		postOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static final ArrayList<Integer> ans = new ArrayList<>();
    //Function to return a list containing the postorder traversal of the tree.
    public static ArrayList<Integer> postOrder(Node root)
    {
        if(root == null) return ans;
        
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.data);
        return ans;
    }
    
    static ArrayList<Integer> postOrderIterativeUsingTwoStack(Node root)
    {
        if(root == null) return ans;
        Stack<Node> stack = new Stack<>();
        Stack<Node> res = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root);
            if(root.left != null) stack.add(root.left);
            if(root.right != null) stack.add(root.right);
        }
        
        while(!res.isEmpty()){
            ans.add(res.pop().data);
        }
        return ans;
    }
    
    static ArrayList<Integer> postOrderIterativeUsingOneStack(Node root)
    {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.peek();
                    stack.pop();
                    ans.add(temp.data);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.peek();
                        stack.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return ans;
    }

}
