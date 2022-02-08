package internship.binarySearchTree;

import java.util.Scanner;

public class CheckDeadEnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		BinarySearchTree tree = new BinarySearchTree();
		
		for(int i=0;i<n;i++) {
			tree.insert(sc.nextInt());
		}
		
		tree.inorder();
		System.out.println(isDeadEnd(tree.root));
		
		sc.close();
	}
	
	static boolean isDeadEnd(Node root)
    {
        return solve(root,1,Integer.MAX_VALUE);
    }
    
    static boolean solve(Node root,int min,int max){
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return max-min == 0 ? true:false;
        boolean ansLeft = solve(root.left,min,root.data-1);
        boolean ansRight = solve(root.right,root.data+1,max);
        
        return ansLeft || ansRight;
    }

}
