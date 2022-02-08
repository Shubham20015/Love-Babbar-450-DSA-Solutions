package internship.binaryTree;

import java.util.Scanner;

public class DiameterOfTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(diameter(root));
		
		sc.close();

	}
	
	static int diameter(Node root) {
        int maxi[] = new int[1];
        heightSum(root,maxi);
        return maxi[0];
    }
    
    static int heightSum(Node root,int maxi[]){
        if(root == null) return 0;
        
        int lh = heightSum(root.left,maxi);
        int rh = heightSum(root.right,maxi);
        maxi[0] = Math.max(maxi[0],lh+rh+1);
        return 1 + Math.max(lh,rh);
    }
}
