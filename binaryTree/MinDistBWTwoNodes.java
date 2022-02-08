package internship.binaryTree;

import java.util.Scanner;

public class MinDistBWTwoNodes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(findDist(root,a,b));
		
		sc.close();
	}
	
	static int findDist(Node root, int a, int b) {
        root = LowestCommonAcestor.lca(root,a,b);
        int d1 = calDist(root,a,0);
        int d2 = calDist(root,b,0);
        return d1 + d2;
    }
    
    static int calDist(Node root,int k,int dist){
        if(root == null) return -1;
        
        if(root.data == k){
            return dist;
        }
        int left = calDist(root.left,k,dist+1);
        if(left != -1) return calDist(root.left,k,dist+1);
        return calDist(root.right,k,dist+1);
    }
}
