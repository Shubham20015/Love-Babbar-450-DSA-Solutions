package internship.binaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class ConvertIntoSumTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		toSumTree(root);
		inOrder(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static void toSumTree(Node root){
         change(root);
    }
    
    static int change(Node root){
        if(root == null){
            return 0;
        }
        int l = change(root.left);
        int r = change(root.right);
        int d = root.data;
        root.data = l + r;
        return l+r+d;
    }
    
    static final ArrayList<Integer> ans = new ArrayList<>();
    
    static ArrayList<Integer> inOrder(Node root) {
        
        if(root == null) return ans;
        
        inOrder(root.left);
        ans.add(root.data);
        inOrder(root.right);
        return ans;
    }

}
