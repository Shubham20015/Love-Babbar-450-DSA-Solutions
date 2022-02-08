package internship.binaryTree;

import java.util.*;

public class DuplicateSubTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(dupSub(root));
		
		sc.close();
	}
	
	static HashMap<String,Integer> map = new HashMap<>();
    static int flag = 0;
    
    static int dupSub(Node root) {
        if(root == null)  return 0;
        solve(root);
        return flag;
    }
    
    static String solve(Node root){
        if(root == null) return "*";
        String str = "";
        str += root.data + solve(root.left) + solve(root.right);
        if(!map.containsKey(str)){
            if(root.left != null && root.right != null)
                map.put(str,1);
        }
        else
            flag = 1;
        return str;
    }

}
