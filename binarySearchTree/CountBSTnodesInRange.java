package internship.binarySearchTree;

import java.util.Scanner;

public class CountBSTnodesInRange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree tree = new BinarySearchTree();
    	
		int n = sc.nextInt();
		int l = sc.nextInt();
		int h = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			tree.insert(sc.nextInt());
		}
		
        tree.inorder();
        System.out.println(getCount(tree.root,l,h));
        
		sc.close();
	}
	
	static int getCount(Node root,int l, int h)
    {
        if(root == null) return 0;
        
        if(root.data >= l && root.data <= h){
            return 1 + getCount(root.left,l,h) + getCount(root.right,l,h);
        }
        else if(root.data < l){
           return getCount(root.right,l,h);
        }
        else{
            return getCount(root.left,l,h);
        }
    }
}
