package internship.binaryTree;

import java.util.*;

public class ZigZagTreeTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		zigZagTraversal(root);
		
		for(int val: al) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static final ArrayList<Integer> al = new ArrayList<>();
  
	static ArrayList<Integer> zigZagTraversal(Node root)
	{
	    if(root == null) return null;
	    
	    boolean even = false;
	    Stack<Integer> stack = new Stack<>();
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    while(!q.isEmpty()){
	        int size = q.size();
	        for(int i=0;i<size;i++){
	            Node temp = q.poll();
	            if(temp.left != null) q.add(temp.left);
	            if(temp.right != null) q.add(temp.right);
	            
	            if(!even) al.add(temp.data);
	            else stack.add(temp.data);
	        }
	        
	        if(even){
	            while(!stack.isEmpty()){
	                al.add(stack.pop());
	            }
	        }
	            even = !even;
	    }
	    
	    return al;
	}
}
