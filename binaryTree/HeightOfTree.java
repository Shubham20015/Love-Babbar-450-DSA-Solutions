package internship.binaryTree;

import java.util.Scanner;

public class HeightOfTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(height(root));
		
		sc.close();

	}
	
	static int height(Node node) 
    {
        if(node == null){
            return 0;
        }
        
        return 1 + Math.max(height(node.left),height(node.right));
    }
}
