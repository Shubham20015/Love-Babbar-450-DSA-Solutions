package internship.binarySearchTree;

import java.util.Scanner;

public class CheckBST {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(isBST(root));
		
		sc.close();
	}
	
	static int flag = 1;
    
    static boolean isBST(Node root)
    {
        flag = 1;
        checkBst(root);
        return flag == 1;
    }
    
    static int checkBst(Node root){
        if(root == null) {
            flag = 0;
            return 0;
        }
        int ldata = 0,rdata = 0;
        if(root.left != null){
            ldata = checkBst(root.left);
            if(root.data <= ldata){
                flag = 0;
                return root.data;
            }
        }
        if(root.right != null){
            rdata = checkBst(root.right);
            if(root.data >= rdata){
                flag = 0;
                return root.data;
            }
        }
        return Math.max(root.data,Math.max(ldata,rdata));
    }

}
