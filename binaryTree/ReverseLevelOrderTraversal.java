package internship.binaryTree;

import java.util.*;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<Integer> ans = reverseLevelOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static ArrayList<Integer> reverseLevelOrder(Node node) 
    {
         ArrayList<Node> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        ans.add(node);
        
        while(ans.size() > 0){
            Node temp = ans.get(0);
            ans.remove(temp);
            res.add(0,temp.data);
            if(temp.right != null)
                ans.add(temp.right);    
            if(temp.left != null)
                ans.add(temp.left);
        }
        
        return res;
    }
}
