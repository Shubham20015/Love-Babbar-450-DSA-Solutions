package internship.binaryTree;

import java.util.Scanner;

public class CheckLeafNodeLevelSameOrNot {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		CheckLeafNodeLevelSameOrNot t = new CheckLeafNodeLevelSameOrNot();
		t.check(root);
		
		System.out.println(t.flag);
		
		sc.close();
	}
	
	public boolean flag = true;
	
    boolean check(Node root)
    {
	    height(root,0);
	    return flag;
    }
	
	int height(Node root,int level){
        if(root == null) return 0;
        
        int lh = height(root.left,level+1);
        int rh = height(root.right,level+1);
        if(root.left != null && root.right != null && lh != rh){
            flag = false;
        }
        return 1 + Math.max(lh,rh);
    }
}
