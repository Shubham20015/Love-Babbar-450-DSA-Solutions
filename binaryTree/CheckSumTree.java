package internship.binaryTree;

import java.util.Scanner;

public class CheckSumTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		CheckSumTree t = new CheckSumTree();
		t.isSumTree(root);
		
		System.out.println(t.flag);
		
		sc.close();
	}
	
	public boolean flag = true;
    
	boolean isSumTree(Node root)
	{
        sumTree(root);
        return flag;
	}
	
	int sumTree(Node root){
	    if(root == null) return 0;
	    if(root.left == null && root.right == null) return root.data;
	    
	    int lsum = sumTree(root.left);
	    int rsum = sumTree(root.right);
	    int sum = lsum + rsum;
	    if(root.data != sum){
	        flag = false;
	    }
	    return sum + root.data;
	}

}
