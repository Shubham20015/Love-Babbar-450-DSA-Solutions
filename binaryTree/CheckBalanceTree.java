package internship.binaryTree;

import java.util.Scanner;

public class CheckBalanceTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(isBalanced(root));
		
		sc.close();

	}
	
	static boolean flag = true;
    
    static boolean isBalanced(Node root)
    {
        if(root == null){
            return false;
        }
	    height(root);
	    return flag;
    }
    
    static int height(Node root){
        if(root == null){
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh-rh) > 1){
            flag = false;
        }
        
        return Math.max(lh,rh) + 1;
    }

}
