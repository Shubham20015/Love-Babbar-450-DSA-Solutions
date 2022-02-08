package internship.binaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class ConstructTreeUsingInorderPreorder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int in[] = new int[n];
		int pre[] = new int[n];
		
		for(int i=0;i<n;i++) {
			in[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			pre[i] = sc.nextInt();
		}
		
		Node root = buildTreeUsingInPre(in,pre,n);
		
		PostOrderTraversal.postOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static int i = 0;
	static final ArrayList<Integer> ans = new ArrayList<>();
	
    public static Node buildTreeUsingInPre(int inorder[], int preorder[], int n)
    {
        i = 0;
        return tree(inorder,preorder,0,n-1);
    }
    
    static Node tree(int inorder[], int preorder[], int x, int n){
        if( x > n) return null;
        
        Node root = new Node(preorder[i++]);
        
        int j;
        for(j=x;j<=n;j++){
            if(inorder[j] == root.data)
                break;
        }
        
        root.left = tree(inorder,preorder,x,j-1);
        root.right = tree(inorder,preorder,j+1,n);
        return root;
    }
}
