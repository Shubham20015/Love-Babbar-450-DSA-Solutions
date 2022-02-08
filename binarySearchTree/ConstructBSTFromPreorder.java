package internship.binarySearchTree;

import java.util.Scanner;

public class ConstructBSTFromPreorder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int pre[] = new int[n];
		
		for(int i=0;i<n;i++) {
			pre[i] = sc.nextInt();
		}
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = constructBST(pre);
	
		tree.inorder();
		
		sc.close();
	}
	
	static int pos = 0;
	
	static Node constructBST(int pre[]) {
		int n = pre.length;
		if(n == 0) return null;
		return build(pre,n,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	
	static Node build(int preorder[],int n, int min, int max){
        if (pos >= n) return null;
        int val = preorder[pos];
        if (val > max || val < min) return null;
        
        Node node = new Node(val);
        ++pos;
        node.left = build(preorder, n, min, val);
        node.right = build(preorder, n, val, max);
        
        return node;
    }
}
