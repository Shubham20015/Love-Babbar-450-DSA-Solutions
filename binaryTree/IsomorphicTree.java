package internship.binaryTree;

import java.util.Scanner;

public class IsomorphicTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		BinaryTree tree1 = new BinaryTree();
		Node root1 = tree1.buildTree(str1);
		
		String str2 = sc.next();
		BinaryTree tree2 = new BinaryTree();
		Node root2 = tree2.buildTree(str2);
		
		System.out.println(isIsomorphic(root1,root2));
		
		sc.close();
	}
	
	static boolean isIsomorphic(Node root1, Node root2)  
    { 
         if(root1 == null && root2 == null){
             return true;
         }
         if(root1 == null || root2 == null){
             return false;
         }
         if(root1.data != root2.data){
             return false;
         }
         
         return (isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right)) ||
         (isIsomorphic(root1.left,root2.right) && isIsomorphic(root1.right,root2.left));
    }
}
