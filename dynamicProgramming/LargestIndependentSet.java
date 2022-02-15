package internship.dynamicProgramming;

public class LargestIndependentSet {
	
	static class Node{
		int data,liss;
		Node left,right;
		Node(int data){
			this.data = data;
			this.liss = 0;
		}
	}
	
	static int LIS(Node root) {
		if(root == null)
			return 0;
		
		int excl = LIS(root.left) +  LIS(root.right);
		
		int incl = 1; // this 1 is for root count
		
		if(root.left != null)
			incl += LIS(root.left.left) +  LIS(root.left.right);
		if(root.right != null)
			incl += LIS(root.right.left) +  LIS(root.right.right);
		
		return Math.max(excl, incl);
	}
	
	static int LISDP(Node root) {
		if(root == null)
			return 0;
		
		if(isLeaf(root))
			return root.liss = 1;
		
		if(root.liss != 0)
			return root.liss;
		
		int excl = LISDP(root.left) +  LISDP(root.right);
		
		int incl = 1;
		
		if(root.left != null)
			incl += LISDP(root.left.left) +  LISDP(root.left.right);
		if(root.right != null)
			incl += LISDP(root.right.left) +  LISDP(root.right.right);
		
		return root.liss = Math.max(excl, incl);
	}
	
	static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}
	
	public static void main(String[] args) {
		Node root = new Node(20);
	    root.left = new Node(8);
	    root.left.left = new Node(4);
	    root.left.right = new Node(12);
	    root.left.right.left = new Node(10);
	    root.left.right.right = new Node(14);
	    root.right = new Node(22);
	    root.right.right = new Node(25);
	    
	    System.out.println("Length of Longest Independent Set: " + LIS(root));
	    System.out.println("Length of Longest Independent Set: " + LISDP(root));
	}

}
