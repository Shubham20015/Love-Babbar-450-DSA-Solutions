package internship.binaryTree;

import java.util.*;

public class MorrisTreeTraversal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<Integer> ans = morrisTraversal(root);
		
		for(int val : ans) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
	static ArrayList<Integer> morrisTraversal(Node root)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            
            if(curr.left == null){
                arr.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    arr.add(curr.data);
                    curr = curr.right;
                }    
            }
        }
        
        return arr;
    }
}
